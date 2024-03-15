package assistantControllers;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import assistantModels.Task;
import assistantModels.taskFolder;

public class dashboardViewTest {
	private Assistant assistant;
	private taskFolder folder1;
	private taskFolder folder2;	
	private ArrayList<Task> arrTask = new ArrayList<Task>();
	
	@Before
	public void setUp() {
		Assistant assistant = new Assistant();
		
		Task task1 = new Task();
		task1.setFolderID(1);
		Task task2 = new Task();
		task2.setFolderID(1);
		Task task3 = new Task();
		task3.setFolderID(1);
		Task task4 = new Task();
		task4.setFolderID(2);
		Task task5 = new Task();
		task5.setFolderID(2);
		
		assistant.setTaskFolder("Class 1", 1);
		
		folder1.setFolderID(1);
		folder2.setFolderID(2);
		
		arrTask.add(task1);
		arrTask.add(task2);
		arrTask.add(task3);
		arrTask.add(task4);
		arrTask.add(task5);
	}
	
	@Test
	public void testTaskFolderProportions() {		
			int numTasks = assistant.getNumTasksByFolder(folder1);
			int totalTasks = assistant.getAllTasks().size();
			float proportions = numTasks / totalTasks;
			assertTrue(proportions == 0.6);
			
	}

}
