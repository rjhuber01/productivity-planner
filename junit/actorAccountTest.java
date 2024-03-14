package junit;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import main.model.actorAccount;

public class ActorAccountTest {
    private actorAccount account;

    @Before
    public void setUp() {
        account = new actorAccount();
    }


    public void testSetAndGetFirstName() {
        account.setFirstName("John");
        assertEquals("John", account.getFirstName());
    }


    public void testSetAndGetLastName() {
        account.setLastName("Doe");
        assertEquals("Doe", account.getlastName());
    }

    
    public void testSetAndGetEmail() {
        account.setEmail("john.doe@example.com");
        assertEquals("john.doe@example.com", account.getEmail());
    }

    
    public void testSetAndGetPassword() {
        account.setPassword("password123");
        assertEquals("password123", account.getPassword());
    }
}


