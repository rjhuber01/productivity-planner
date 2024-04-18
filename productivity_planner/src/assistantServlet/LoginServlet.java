package assistantServlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import assistantModels.*;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("Login Servlet: doGet");	
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Login Servlet: doPost");
		
		 String email = req.getParameter("email");
	     String password = req.getParameter("password");
	     System.out.println("Email: " + email);
	     System.out.println("Password: " + password);
	     String errorMessage = null;
	     actorAccount userLogin = null;
	     
	     /* Check to see if login is valid
	      * 1. See if email is actually an email
	      * 2. If valid, lookup user email, password, and salt
	      * 3. Add salt to password (password + salt)
	      * 4. Hash password 
	      * 5. Compare password from user input with password from respective email
	      * TODO: Implement new class with validation instead of copy paste methods (NON PRIORITY)
	      */
	     
	     if(validateEmail(email) == false
	    		 || email == null 
	    		 || password == null) {
	    	 errorMessage = "Email or password missing. Please try again with a valid address.";
	    	 req.setAttribute("errorMessage", errorMessage);
	    	 req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);;
	     } 
	     
	     //Retrieve session with user
	     //TODO: Replace with DB query(ies). 
	     HttpSession session = req.getSession(true);
	     userLogin = (actorAccount) session.getAttribute("newAccount");
	     String accountEmail = userLogin.getEmail();
	     String accountPassword = userLogin.getPassword();
	     String accountSalt = userLogin.getSalt();
	     password = hashPassword(password + accountSalt);
	     if(email.equals(accountEmail) && password.equals(accountPassword)) {
	    	 session.setAttribute("account", userLogin);
	    	 resp.sendRedirect("dashboard");
	     } else {
	    	 errorMessage = "Email and Password Combination Incorrect. Please Try Again. ";
	    	 req.setAttribute("errorMessage", errorMessage);
	    	 req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);;
	     }
	}
	
		/* private actorAccount authenticate(String email, String password) {
        // Retrieve account from accountStorage based on email
        accountStorage storage = new accountStorage();
        actorAccount account = storage.getAccount(email);

        if (account != null) {
        // Validate password using hashedPassword from the account and hashPassword method
        	String hashedPassword = hashPassword(saltedPassword);
        	if (hashedPassword.equals(account.getHashedPassword())) {
                    // Password matches, return account
        		return account;
        	}
        } 
            return null; // Authentication failed
        } */
		
	    private boolean validateEmail(String email) {
	    	final String EMAIL_PATTERN = "^(?:(?:[^<>()\\[\\].,;:\\s@\"]+(?:\\.[^<>()\\[\\].,;:\\s@\"]+)*)|(?:\".+\"))@(?:(?:\\[(?:[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})\\])|(?:[a-zA-Z\\-0-9]+(?:\\.[a-zA-Z\\-0-9]+)*))$";
	    	final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
	    	Matcher matcher = pattern.matcher(email);
	    	return matcher.matches();
	    }
	    
	    private String hashPassword(String saltedPassword) {
	        try {
	            MessageDigest digest = MessageDigest.getInstance("SHA-256");
	            byte[] hashBytes = digest.digest(saltedPassword.getBytes(StandardCharsets.UTF_8));
	            StringBuilder hexString = new StringBuilder();
	            for (byte b : hashBytes) {
	                String hex = Integer.toHexString(0xff & b);
	                if (hex.length() == 1) hexString.append('0');
	                hexString.append(hex);
	            }
	            return hexString.toString();
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Error hashing password", e);
	        }
	    }
	
}