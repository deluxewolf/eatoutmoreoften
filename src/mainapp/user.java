package mainapp;

/**
 *
 * @author Shuaib
 */
public class user{
        
    String username;
    String password;
    String accType;
        
        
    public user(String user, String pass, String type){
        username = user;
        password = pass;
        accType = type;
        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }
}
