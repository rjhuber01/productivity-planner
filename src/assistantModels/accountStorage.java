package assistantModels;
import java.util.ArrayList;

public class accountStorage{
    private ArrayList<actorAccount> accountStorage = new ArrayList<>();
    
    public void createAccount(String firstName, String lastName, String email, String password){
    	actorAccount newAccount = new actorAccount();
    	newAccount.setEmail(email);
    	newAccount.setFirstName(firstName);
    	newAccount.setLastName(lastName);
    	newAccount.setPassword(password);
    	accountStorage.add(newAccount);
    }
    //this method returns an actor account from the arraylist
    public actorAccount getAccount(String email) {
    	for (actorAccount account : accountStorage) {
            if (account.getEmail().equals(email)) {
                return account;
            }
        }
        return null;
    }
    
    public void deleteAccount(actorAccount account) {
    	accountStorage.remove(account);
    }
}
