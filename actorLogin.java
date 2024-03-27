<<<<<<< Updated upstream:actorLogin.java
=======
package assistantModels;

>>>>>>> Stashed changes:productivity_planner/src/assistantModels/actorLogin.java
public class actorLogin {
    private String email, password, saltHash;
   
    
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

    public void setSaltHash(String saltHash){
        this.saltHash = saltHash;
    }

    public String getSaltHash(){
        return saltHash;
    }

}
