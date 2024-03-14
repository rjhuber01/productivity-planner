package junit;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import main.model.taskFolder;

public class TaskFolderTest {
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