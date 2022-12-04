package entity.User;

public interface UserFactory {

    User create(String username, String firstName, String lastName);
}
