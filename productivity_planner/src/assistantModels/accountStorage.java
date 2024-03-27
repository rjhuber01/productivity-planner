package assistantModels;
import java.util.ArrayList;
import assistantModels.actorAccount;

public class accountStorage{
    private static ArrayList<actorAccount> accountStorage = new ArrayList<>();
    private static actorAccount userAccount = new actorAccount();
    
    public void createAccount(String firstName, String lastName, String email, String password){
    	actorAccount newAccount = new actorAccount();
    	newAccount.setEmail(email);
    	newAccount.setFirstName(firstName);
    	newAccount.setLastName(lastName);
    	newAccount.setPassword(password);
    	accountStorage.add(newAccount);
    }
    
    public static void deleteAccount(actorAccount account) {
    	accountStorage.remove(account);
    }
    
    public actorAccount getAccount(String email) {
    	for (actorAccount account : accountStorage) {
            if (account.getEmail().equals(email)) {
            	String hashedPassword = account.getHashedPassword(); 
                return account;
            }
        }
        return null;
    }
    
    public String getSaltByEmail(String email) {
        for (actorAccount account : accountStorage) {
            if (account.getEmail().equals(email)) {
                return account.getSalt(); 
            }
        }
        return null; // User not found or salt not available
    }
}
