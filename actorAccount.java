<<<<<<< Updated upstream:actorAccount.java

public class actorAccount {
<<<<<<< Updated upstream:actorAccount.java
    private String firstName, lastName, email, password;
   
=======
    private String firstName, lastName, email, password, salt, hashedPassword;
>>>>>>> Stashed changes:productivity_planner/src/assistantModels/actorAccount.java
=======
package assistantModels;

public class actorAccount {
    private String firstName, lastName, email, password, salt, hashedPassword;
>>>>>>> Stashed changes:productivity_planner/src/assistantModels/actorAccount.java
    
    public actorAccount() {

    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getlastName(){
        return lastName;
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
<<<<<<< Updated upstream:actorAccount.java
<<<<<<< Updated upstream:actorAccount.java

    
=======
=======
>>>>>>> Stashed changes:productivity_planner/src/assistantModels/actorAccount.java
    
    public void setSalt(String salt){
        this.salt = salt;
    }

    public String getSalt(){
        return salt;
    }

    public String getHashedPassword(){
        return hashedPassword;
    }
<<<<<<< Updated upstream:actorAccount.java
>>>>>>> Stashed changes:productivity_planner/src/assistantModels/actorAccount.java
=======
>>>>>>> Stashed changes:productivity_planner/src/assistantModels/actorAccount.java
}