package productivity_planner_Tests.assistantModels;
import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import assistantModels.Task;

public class taskTest {
    private Task task;

    @Before
    public void setUp() {
        task = new Task();
    }

    @Test
    public void testSetAndGetTaskName() {
        task.setTaskName("Test Task");
        assertEquals("Test Task", task.getTaskName());
    }


    public void testSetAndGetFolderID() {
        task.setFolderID(1);
        assertEquals(1, task.getFolderID());
    }

    
    public void testSetAndGetExpectedTime() {
        task.setExpectedTime(60);
        assertEquals(60, task.getExpectedTime());
    }

    
    /* public void testSetAndGetDueDate() {
        Date dueDate = new Date(1,2,3);
        task.setDueDate(dueDate);
        assertEquals(dueDate, task.getdueDate());
    } */
    
    public void testSetAndGetTimeUnit() {
        task.setTimeUnit(1);
        assertEquals(1, task.getTimeUnit());
    }

    
    public void testSetAndGetColor() {
        task.setColor(2);
        assertEquals(2, task.getColor());
    }

    
    public void testSetAndGetStatus() {
        task.setStatus(1);
        assertEquals(1, task.getStatus());
    }

    
    public void testSetAndGetRank() {
        task.setRank(5);
        assertEquals(5, task.getRank());
    }

    
    public void testSetAndGetFrequency() {
        task.setFrequency(3);
        assertEquals(3, task.getFrequency());
    }

    
    public void testSetAndGetTaskDescription() {
        task.setTaskDescription("Test Description");
        assertEquals("Test Description", task.getTaskDescription());
    }
}
