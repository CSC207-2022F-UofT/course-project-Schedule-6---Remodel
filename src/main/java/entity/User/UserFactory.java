package entity.User;

public interface UserFactory {

    User create(String firstName, String lastName, String Password);
}
