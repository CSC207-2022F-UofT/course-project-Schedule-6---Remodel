package requestModel;

public class UserLoginRequestModel {

    private final String username;

    private final String password;


    /**
     * Input data from the User in the LoginScreen
     * Used for the use case to check if user exists and if the username and password matches
     *
     * @param username the unique identification name created by the User
     * @param password a password created by the User
     */
    public UserLoginRequestModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}
