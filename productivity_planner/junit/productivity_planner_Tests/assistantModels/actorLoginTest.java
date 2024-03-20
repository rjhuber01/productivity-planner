package productivity_planner_Tests.assistantModels;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import assistantModels.actorLogin;

public class actorLoginTest {
    private actorLogin login;

    @Before
    public void setUp() {
        login = new actorLogin();
    }

    @Test
    public void testSetAndGetEmail() {
        login.setEmail("test@example.com");
        assertEquals("test@example.com", login.getEmail());
    }

    public void testSetAndGetSaltHash() {
        login.setSaltHash("saltHashValue");
        assertEquals("saltHashValue", login.getSaltHash());
    }

}

