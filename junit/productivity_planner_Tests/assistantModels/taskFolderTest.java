package productivity_planner_Tests.assistantModels;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import assistantModels.taskFolder;

public class taskFolderTest {
    private taskFolder folder;

    @Before
    public void setUp() {
        folder = new taskFolder();
    }

    @Test
    public void testSetAndGetFolderName() {
        folder.setFolderName("Test Folder");
        assertEquals("Test Folder", folder.getFolderName());
    }

    @Test
    public void testSetAndGetFolderID() {
        folder.setFolderID(1);
        assertEquals(1, folder.getFolderID());
    }
}