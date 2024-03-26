package assistantServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class pomodoroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("Pomodoro Servlet: doGet");	
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/pomoTimer.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Pomodoro Servlet: doPost");
		
		// holds the error message text, if there is any
		String errorMessage = null;
		
		// decode POSTed form parameters and dispatch to controller

			// check for errors in the form data before using is in a calculatio
			// otherwise, data is good, do the calculation
			// must create the controller each time, since it doesn't persist between POSTs
			
		
		// add result objects as attributes
		// this adds the errorMessage text and the result to the response
		//req.setAttribute("errorMessage", errorMessage);
		
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/pomoTimer.jsp").forward(req, resp);
	}

	// gets double from the request with attribute named s
	private Double getDoubleFromParameter(String s) {
		if (s == null || s.equals("")) {
			return null;
		} else {
			return Double.parseDouble(s);
		}
	}
}
