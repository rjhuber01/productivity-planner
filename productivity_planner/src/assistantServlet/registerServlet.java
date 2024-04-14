package assistantServlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import assistantModels.*;

public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("Registration Servlet: doGet");	
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/register.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// create user by getting info and password
		String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String errorMessage = null;
		String salt = null;
		String hashedPassword = null;
		
		 /* Validate User Entries
		 * Checks that need to occur:
		 * Completed - 1. User email must be valid
		 * TODO: 2. User email must NOT already exist in DB */
		if(validateEmail(email) == false ||
				firstName == null ||
				lastName == null || 
				email == null || 
				password == null) {
			errorMessage = "One or more of the fields was incorrect. Please try again.";
			req.setAttribute("errorMessage", errorMessage);
			req.getRequestDispatcher("/_view/register.jsp").forward(req, resp);;
		} else {
			System.out.println("Valid Email: Moving On");
			
			//Create instance of actorLogin but create salt here 1 time. 
			actorAccount newAccount = new actorAccount();
			salt = createSalt();
			password = password + salt;
			hashedPassword = hashPassword(password);
			System.out.println("Salt: " + salt);
			System.out.println("Original password: " + password);
			System.out.println("Hashed Password: " + hashedPassword);
			
			//Set parameters of account
			newAccount.setFirstName(firstName);
			newAccount.setLastName(lastName);
			newAccount.setSalt(salt);
			newAccount.setPassword(hashedPassword);
			newAccount.setEmail(email);
			
			//TODO: Store account in DB. Temporarily storing login in session
			HttpSession session = req.getSession(true);
			session.setAttribute("newAccount", newAccount);
			
			//Forward user to login page.
			req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);	
		}
	}
	
	
	// Hash the password using SHA-256
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
    
    //Validate email using RegEx Expression compliant with RFC2822 Standards
    //See documentation at https://datatracker.ietf.org/doc/html/rfc2822
    private boolean validateEmail(String email) {
    	final String EMAIL_PATTERN = "^(?:(?:[^<>()\\[\\].,;:\\s@\"]+(?:\\.[^<>()\\[\\].,;:\\s@\"]+)*)|(?:\".+\"))@(?:(?:\\[(?:[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})\\])|(?:[a-zA-Z\\-0-9]+(?:\\.[a-zA-Z\\-0-9]+)*))$";
    	final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    	Matcher matcher = pattern.matcher(email);
    	return matcher.matches();
    }
    
    //Create Random Salt for User
    private String createSalt() {
    	Random random = new SecureRandom();
    	byte[] salt = new byte[16];
    	random.nextBytes(salt);
    	return Base64.getEncoder().encodeToString(salt);
    }
}