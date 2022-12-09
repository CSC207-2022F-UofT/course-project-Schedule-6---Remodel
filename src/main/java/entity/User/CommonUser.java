package entity.User;

// Entity layer

public class CommonUser implements User {

    private final String username;

    private final String password;

    private final String firstName;

    private final String lastName;

    /**
     * An entity that contains User info
     *
     * @param username  the unique identification name created by the User
     * @param password  a password created by the User
     * @param firstName first name of the User
     * @param lastName  last name of the User
     */
    public CommonUser(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }
}