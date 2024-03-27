package assistantServlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
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
		
		System.out.println("Login Servlet: doPost");
		
		// create user by getting info and password
		String firstName = req.getParameter("firstName");
		System.out.println(firstName);
        String lastName = req.getParameter("lastName");
        System.out.println(lastName);
		String email = req.getParameter("email");
		System.out.println(email);
		String password = req.getParameter("password");
		System.out.println(password);
	
		//Create an instance of actorLogin
		actorLogin login = new actorLogin();
		String salt = login.getSaltHash();
		String saltedPassword = password + salt;
		String hashedPassword = hashPassword(saltedPassword);
    	
		login.setPassword(password);
     
		
<<<<<<< Updated upstream
		// create user by getting info and password
		String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		String password = req.getParamter("passsword");
	
		//Create an instance of actorLogin
		actorLogin login = new actorLogin();
		String salt = login.getSaltHash();
		String saltedPassword = password + salt;
		String hashedPassword = hashPassword(saltedPassword);
    	
		login.setPassword(password);
     
		
		//Create an instance of Actor and set details
		accountStorage storage = new accountStorage();
		storage.createAccount(firstName, lastName, email, hashedPassword);
		
		HttpSession session = req.getSession();
    	session.setAttribute("userAccount", storage.getAccount(email) );
		
		// Forward to view to render the result HTML document
    	//resp.sendRedirect("login");
		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
			
		
		
=======
		//Create an instance of Actor and set details
		accountStorage storage = new accountStorage();
		storage.createAccount(firstName, lastName, email, hashedPassword);
		
		HttpSession session = req.getSession();
    	session.setAttribute("userAccount", storage.getAccount(email));
		
		// Forward to view to render the result HTML document
    	//resp.sendRedirect("login");
		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);	
	}
>>>>>>> Stashed changes
	
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

	
<<<<<<< Updated upstream
}
=======
}
>>>>>>> Stashed changes
