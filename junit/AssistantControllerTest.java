
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.Assistant;
import model.actorAccount;
import model.Task;
import model.taskFolder;

public class AssistantControllerTest {
    private Assistant assistant;
    private AssistantController controller;

    @Before
    public void setUp() {
        assistant = new Assistant();
        controller = new AssistantController();

        controller.setAssistant(assistant);

    }

    @Test
    public void testActorAccount() {
       actorAccount userAccount = assistant.getActorAccount();
       assertNotNull(userauserAccount);
       assertNotNull(userAuserAccount.getEmail());
       // Do any more specifics need to be tested here (password?)
    }

    public void testSetTaskFolder() {
        controller.setTaskFolder(folderName,folderID)

        TaskFolder folder = controller.getTaskFolder();
        assertEquals(folder.setTaskFolder, folder.getTaskFolder);
        assertEquals(folderName, folder.setFolderName);
        assertEquals(folderID, folder.setFolderID);

    }

    public void testDefaultTaskFolder() {
        TaskFolder folder = controller.getTaskFolder();
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

        controller.setTask("Study", "Description", 2, 3, 2, 2, 0);
        Task retrievedTask = controller.getTask();

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
        controller.getAllTasks().add(task);
        controller.deleteTask(0);
        assertEquals(0, controller.getAllTasks().size());
    }

}
