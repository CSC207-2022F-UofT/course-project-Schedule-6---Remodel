package boundary.User;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import responseModel.User.UserLoginResponseModel;

public interface UserLoginOutputBoundary {
    void loginMessage(Label label, String message);

    void prepareSuccessView(UserLoginResponseModel responseModel);

    void prepareFailView(UserLoginResponseModel responseModel);
}
