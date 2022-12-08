package entity.User;

// Entity layer

public class CommonUserFactory implements UserFactory {
    @Override
    public User create(String username, String password, String firstName, String lastname) {
        return new CommonUser(username, password, firstName, lastname);
    }
}