package entity.User;

// Entity layer

public class CommonUserFactory implements UserFactory {
    @Override
    public User create(String username, String name, String password) {
        return new CommonUser(username, name, password);
    }
}