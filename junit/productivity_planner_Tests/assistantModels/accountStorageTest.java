package productivity_planner_Tests.assistantModels;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import assistantModels.accountStorage;
import assistantModels.actorAccount;

public class accountStorageTest {

	@Test
	public void testCreateAccount() {
		accountStorage userData = new accountStorage();
		actorAccount ryanAccount = new actorAccount();
		ryanAccount.setFirstName("Ryan");
		ryanAccount.setLastName("Huber");
		ryanAccount.setEmail("rhuber1@ycp.edu");
		ryanAccount.setPassword("password");
		userData.createAccount("Ryan", "Huber", "rhuber1@ycp.edu", "password");
		assertTrue(userData.getAccount("rhuber1@ycp.edu") == ryanAccount);
	}
	
	@Test
	public void testDeleteAccount() {
		accountStorage userData = new accountStorage();
		actorAccount ryanAccount = new actorAccount();
		ryanAccount.setFirstName("Ryan");
		ryanAccount.setLastName("Huber");
		ryanAccount.setEmail("rhuber1@ycp.edu");
		ryanAccount.setPassword("password");
		userData.createAccount("Ryan", "Huber", "rhuber1@ycp.edu", "password");
		userData.deleteAccount(ryanAccount);
		assertFalse(userData.getAccount("rhuber1@ycp.edu") == ryanAccount);
	}
	
	@Test
	public void testGetAccount() {
		accountStorage userData = new accountStorage();
		actorAccount ryanAccount = new actorAccount();
		ryanAccount.setFirstName("Ryan");
		ryanAccount.setLastName("Huber");
		ryanAccount.setEmail("rhuber1@ycp.edu");
		ryanAccount.setPassword("password");
		userData.createAccount(ryanAccount.getFirstName(), ryanAccount.getlastName(), ryanAccount.getEmail(), ryanAccount.getPassword());
		assertTrue(userData.getAccount("rhuber1@ycp.edu") == ryanAccount);
	}
	
}
