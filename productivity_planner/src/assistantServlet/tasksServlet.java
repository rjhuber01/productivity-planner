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
		
		HttpSession session = req.getSession(true);
		Assistant taskController = (Assistant) session.getAttribute("taskController");
		if(taskController == null) {
			taskController = new Assistant();
			session.setAttribute("taskController", taskController);
		}
		
		//Retrieve parameters from task.JSP in ArrayList form
		// Order relates to
		taskID = taskController.getTaskCounter();
		System.out.println("TaskID from Counter: " + taskID);
		String taskName = req.getParameter("taskName");
		String taskFolder = req.getParameter("taskFolder");
		String dueDate = req.getParameter("dueDate");
		
		//TODO: Converted to a number from the JSP
		String expectedTimeString = req.getParameter("expectedTime");
		
		int expectedTime = Integer.parseInt(expectedTimeString);
		String statusString = req.getParameter("status");
		int status = Integer.parseInt(statusString);
		String taskDescription = req.getParameter("taskDescription");
		taskID += 1;
		System.out.println("Task ID Incremented: " + taskID);
		
		//Get all tasks and then see if it exists. If it exists, modify or else create new. 
		if(taskController.getTaskByID(taskID) != null) {
			//Task already exists 
			Task existingTask = taskController.getTaskByID(taskID);
			taskController.updateExistingTask(existingTask, taskName, taskFolder, dueDate, expectedTime, status, taskDescription);
		} else {
			//Task does not exist...new. 
			taskController.setTask(taskName, taskFolder, dueDate, expectedTime, status, taskDescription);
		}
		
		//TODO: Handle Exceptions for Non-Required Fields
		//DISCUSS: Why does refreshing the page not do what I need to do? 
		
		//Store form data 
		session.setAttribute("taskController", taskController);
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/tasks.jsp").forward(req, resp);
	}
}
