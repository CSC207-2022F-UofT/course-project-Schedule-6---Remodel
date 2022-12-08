package entity.User;

public interface UserFactory {

    User create(String username, String password, String firstName, String lastName);
}
