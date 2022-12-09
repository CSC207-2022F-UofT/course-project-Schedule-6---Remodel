package entity.User;

/**
 * Interface the CommonUserFactory implements
 */
public interface UserFactory {
    /**
     * create() takes in required parameters for creating a User entity, and returns that User
     *
     * @param username  the unique identification name created by the User
     * @param password  a password created by the User
     * @param firstName first name of the User
     * @param lastName  last name of the User
     * @return the new CommonUser
     */
    User create(String username, String password, String firstName, String lastName);
}
