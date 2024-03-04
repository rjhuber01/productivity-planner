
public class Actor {
    private String firstName, lastName, email, password;
    private int notification;
    
    public Actor() {

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
        return firstName;
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

    public void setNotification(int notification){
        this.notification = notification;
    }

    public int getNotification(){
        return notification;
    }
}