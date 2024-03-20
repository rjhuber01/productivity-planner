package productivity_planner_Tests.assistantControllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import assistantControllers.Assistant;
import assistantModels.actorAccount;
import assistantModels.Task;
import assistantModels.taskFolder;

public class assistantTest {
    private Assistant assistant;

    @Before
    public void setUp() {
        assistant = new Assistant();

    }

    @Test
    public void testActorAccount() {
    	String email = "klindemann@ycp.edu";
        actorAccount userAccount = assistant.getActorAccount();
        userAccount.setEmail(email);
        assertEquals(userAccount.getEmail(), "klindemann@ycp.edu");
        assertNotNull(email);
       // Do any more specifics need to be tested here (password?)
    }

    public void testSetTaskFolder() {
        assistant.setTaskFolder("Math", 1);

        taskFolder folder = assistant.getTaskFolder();
        assertEquals(folder.getFolderName(), "Math");
        assertEquals(folder.getFolderID(), 1);
    }

    public void testDefaultTaskFolder() {
        taskFolder folder = assistant.getTaskFolder();
        assertEquals("AllTasks", folder.getFolderName());
        assertEquals(0, folder.getFolderID());
    }

    public void testSetTask() {
        Task task = new Task();
        task.setTaskDescription("Description");
        task.setTimeUnit(2);
        task.setColor(3);
        task.setFrequency(2);
        task.setTaskName("Study");
        task.setRank(2);
        task.setStatus(0);

        assistant.setTask("Study", "Description", 2, 3, 2, 2, 0, 0);
        Task retrievedTask = assistant.getTask();

        assertEquals(task.getTaskDescription(), retrievedTask.getTaskDescription());
        assertEquals(task.getTimeUnit(), retrievedTask.getTimeUnit());
        assertEquals(task.getColor(), retrievedTask.getColor());
        assertEquals(task.getFrequency(), retrievedTask.getFrequency());
        assertEquals(task.getTaskName(), retrievedTask.getTaskName());
        assertEquals(task.getRank(), retrievedTask.getRank());
        assertEquals(task.getStatus(), retrievedTask.getStatus());
    }

    public void testDeleteTask() {
        Task task = new Task();
        assistant.getAllTasks().add(task);
        assistant.deleteTask(0);
        assertEquals(0, assistant.getAllTasks().size());
    }

}
