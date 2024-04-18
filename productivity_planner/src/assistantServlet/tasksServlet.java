package assistantServlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import assistantControllers.Assistant;
import assistantModels.Task;

public class tasksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int taskID = 1;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("Tasks Servlet: doGet");	
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/tasks.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//Create HTTP Session and keep assistantController
		System.out.println("Task Servlet: doPost");
		
		//Declaration of all variables BEFORE creating controller & handle null exceptions
		String taskName, taskFolder, dueDate, taskTime, timeUnit;
		String status, rank, taskDescription, errorMessage;
		taskName = req.getParameter("taskName");
		taskFolder = req.getParameter("taskFolder") != null ? req.getParameter("taskFolder") : "Tasks" ;
		dueDate = req.getParameter("dueDate");
		taskTime = req.getParameter("taskTime") != null ? req.getParameter("taskTime") : "30" ;
		timeUnit = req.getParameter("timeUnit") != null ? req.getParameter("timeUnit") : "minutes" ;
		status = req.getParameter("status") != null ? req.getParameter("status") : "Incomplete" ;
		rank = req.getParameter("rank") != null ? req.getParameter("rank") : "Unimportant" ;
		taskDescription = req.getParameter("taskDescription") != null ? req.getParameter("taskDescription") : "" ;
		
		//These are set up in JSP to be required fields but issue error just in case
		if(taskName == null || dueDate == null) {
			errorMessage = "Missing Information. Please fill out ALL required fields";
			//TODO: Send error message to page
		}
		
		
		System.out.println("1 " + taskName);
		System.out.println("2 " + taskFolder); //BLANK
		System.out.println("3 " + dueDate); //Prints out in YYYY-MM-DD format
		System.out.println("4 " + taskTime); //BLANK
		System.out.println("5 " + timeUnit);
		System.out.println("6 " + status);
		System.out.println("7 " + rank);
		System.out.println("8 " + taskDescription); 
		
		
		HttpSession session = req.getSession(true);
		Assistant taskController = (Assistant) session.getAttribute("taskController");
		if(taskController == null) {
			taskController = new Assistant();
			session.setAttribute("taskController", taskController);
		}
		
		//Retrieve parameters from task.JSP in ArrayList form
		// Order relates to
		
		//TODO: Converted to a number from the JSP
		String expectedTimeString = req.getParameter("expectedTime");
		
		/* int expectedTime = Integer.parseInt(expectedTimeString);
		String statusString = req.getParameter("status");
		int status = Integer.parseInt(statusString);
		String taskDescription = req.getParameter("taskDescription");
		
		//Get all tasks and then see if it exists. If it exists, modify or else create new. 
		System.out.println(taskID);
		System.out.println(taskController.getTaskByID(taskID));
		if(taskController.getTaskByID(taskID) != null) {
			//Task already exists 
			Task existingTask = taskController.getTaskByID(taskID);
			taskController.updateExistingTask(existingTask, taskName, taskFolder, dueDate, expectedTime, status, taskDescription);
		} else {
			//Task does not exist...new. 
			taskID += 1;
			taskController.setTask(taskName, taskFolder, dueDate, expectedTime, status, taskDescription);
		} */
		
		//TODO: Handle Exceptions for Non-Required Fields
		//DISCUSS: Why does refreshing the page not do what I need to do? 
		
		//Store form data 
		session.setAttribute("taskController", taskController);
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/tasks.jsp").forward(req, resp);
	}
}
