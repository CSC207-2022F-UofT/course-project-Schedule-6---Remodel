package requestModel;

public class UserRegisterRequestModel {

    private String username;
    private String password;
    private String repeatPassword;

    private String firstName;

    private String lastName;

    public UserRegisterRequestModel(String username, String password, String repeatPassword,
                                    String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getRepeatPassword() {
        return this.repeatPassword;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
}
