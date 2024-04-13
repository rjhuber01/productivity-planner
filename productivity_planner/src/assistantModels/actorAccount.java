package assistantModels;

public class actorAccount {
    private String firstName, lastName, email, password, salt, hashedPassword;
    
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
    
    public void setSalt(String salt){
        this.salt = salt;
    }

    public String getSalt(){
        return salt;
    }

    public String getHashedPassword(){
        return hashedPassword;
    }
}