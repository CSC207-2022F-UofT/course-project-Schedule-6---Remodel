package requestModel;

public class UserRegisterRequestModel {

    private final String username;

    private final String password;

    private final String firstName;

    private final String lastName;

    /**
     * Input data from the User
     * Used to create a new User entity in the use case
     *
     * @param username  the unique identification name created by the User
     * @param password  a password created by the User
     * @param firstName first name of the User
     * @param lastName  last name of the User
     */
    public UserRegisterRequestModel(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
}
