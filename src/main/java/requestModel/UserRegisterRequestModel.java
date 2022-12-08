package requestModel;

public class UserRegisterRequestModel {

    private final String username;

    private final String password;

    private final String firstName;

    private final String lastName;

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
