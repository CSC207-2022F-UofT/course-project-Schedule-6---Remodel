package entity.User;

public class CommonUserFactory implements UserFactory {

    /**
     * Overrides create() method in UserFactory
     * create() takes in required parameters for creating a User, and returns that User entity.
     *
     * @param username  the unique identification name created by the User
     * @param password  a password created by the User
     * @param firstName first name of the User
     * @param lastName  last name of the User
     * @return the new CommonUser
     */
    @Override
    public User create(String username, String password, String firstName, String lastName) {
        return new CommonUser(username, password, firstName, lastName);
    }
}