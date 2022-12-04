package entity.User;

// Entity layer

public class CommonUser implements User {

    private final String username;
    private final String password;

    public CommonUser(String username, String password) {
        this.username = username;
        this.password = password;

    }

    @Override
    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

}