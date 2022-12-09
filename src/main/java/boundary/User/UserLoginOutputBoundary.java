package boundary.User;

import javafx.scene.control.Label;
import responseModel.User.UserLoginResponseModel;

/**
 * Interface for UserLoginPresenter
 * Allows the use case (UserLogin) to call the presenter (UserLoginPresenter)
 */
public interface UserLoginOutputBoundary {
    void loginMessage(Label label, String message);

    void prepareSuccessView(UserLoginResponseModel responseModel);

    void prepareFailView(UserLoginResponseModel responseModel);
}
