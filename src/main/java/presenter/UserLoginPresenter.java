package presenter;

import boundary.User.UserLoginOutputBoundary;
import controller.User.userCollection;
import javafx.animation.FadeTransition;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;
import responseModel.User.UserLoginResponseModel;
import screens.CreateEventScreen;
import screens.TimetableScreen;

public class UserLoginPresenter implements UserLoginOutputBoundary {

    private Label label;

    private Button button;

    public UserLoginPresenter(Label label, Button button) {
        this.label = label;
        this.button = button;
    }

    @Override
    public void loginMessage(Label label, String message) {
        label.setText(message);
        FadeTransition ft = new FadeTransition(Duration.millis(2850), label);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setAutoReverse(true);
        ft.play();
    }

    @Override
    public void prepareSuccessView(UserLoginResponseModel responseModel) {
        label.setText(responseModel.getMessage());
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
        //The event form opens
        CreateEventScreen.newForm();
        TimetableScreen.usernameChangeLabel.setText(userCollection.getUsername());
    }

    @Override
    public void prepareFailView(UserLoginResponseModel responseModel) {
        loginMessage(label, responseModel.getMessage());
    }
}
