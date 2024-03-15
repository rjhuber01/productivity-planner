package assistantModels;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

public class actorLogin {
    private String email, password, saltHash;
    private static final Random RANDOM = new SecureRandom();
    
    public actorLogin() {
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    //DISCUSS: Should this be modified to pull secureHash && Connect it to actorAccount? 
    public void setSaltHash(String saltHash){
        this.saltHash = saltHash;
    }

    public String getSaltHash(){
        byte[] saltString = new byte[16];
        RANDOM.nextBytes(saltString);
        String securePass = Base64.getEncoder().encodeToString(saltString);
        System.out.println(securePass);
        return securePass;
    }

}
