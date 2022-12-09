package boundary.User;

/**
 * Interface for UserLogin use case
 * Allows the controller (MainController) to call the use case (UserLogin)
 */
public interface UserLoginInputBoundary {
    void loginCheck();
}
