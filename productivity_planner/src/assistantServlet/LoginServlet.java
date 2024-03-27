package assistantServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
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
	     
	     // Create an instance of actorLogin
	        actorLogin login = new actorLogin();
	   // Retrieve the salt from the accountStorage based on the email
	        accountStorage storage = new accountStorage();
	        String salt = storage.getSaltByEmail(email);
	        
	        if (salt != null) {
	            String saltedPassword = password + salt;
	            // Hash the salted password
	            String hashedPassword = login.hashPassword(saltedPassword);
	            
	            actorAccount account = storage.getAccount(email);
	            
	            if (account != null && hashedPassword.equals(account.getPassword())) {
	            // Re-hash the entered password
	        	// Authentication successful, store account details in session
	            	HttpSession session = req.getSession();
	            	//getAttribute ?
	            	session.setAttribute("account", account);
	            
	            	// Redirect to home page
	            	resp.sendRedirect("dashboard.jsp");
	            	return;
	            }
	        
	        }
	        
	        // Authentication failed, redirect back to login page with error message
	        resp.sendRedirect("login.jsp?error=1");
<<<<<<< Updated upstream
	        
	    
=======
>>>>>>> Stashed changes
		
		// holds the error message text, if there is any
		String errorMessage = null;
		
		 // Authenticate user using actorLogin and accountStorage
<<<<<<< Updated upstream
			private actorAccount authenticate(String email, String password) {
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
	        }

		
		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
	

	
}
=======
		
		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
	}
	
		private actorAccount authenticate(String email, String password) {
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
        }
	
}
>>>>>>> Stashed changes
