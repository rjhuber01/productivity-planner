package assistantControllers;
import assistantModels.accountStorage;
import assistantModels.actorAccount;
import java.util.ArrayList;

public class settingsView {
    private int color;
    private boolean incorrectPassword;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    //TODO: Implement logout
    //public void logout() {
    	//return;
    //}

    public void deleteAccount() {
    	
    }

    public void changePassword(String currentPassword, String newPassword) {
    	if(currentPassword == actorAccount.getPassword()) {
    		actorAccount.setPassword(newPassword);
    		incorrectPassword = false;
    	}
    	else {
    		incorrectPassword = true;
    	}
    }
    
    public void deleteAccount(actorAccount account) {
    	accountStorage.deleteAccount(account);
    }
}
