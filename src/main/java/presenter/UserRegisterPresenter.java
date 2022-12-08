package presenter;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

public class UserRegisterPresenter {

    public UserRegisterPresenter() {
    }

    public void registrationMessage(Label label, String message) {
        label.setText(message);
        FadeTransition ft = new FadeTransition(Duration.millis(4000), label);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setAutoReverse(true);
        ft.play();
    }

    public void prepeareSuccessAction(Label label, String message, Button closeButton) {
        label.setText(message);
        FadeTransition ft = new FadeTransition(Duration.millis(4000), label);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setAutoReverse(true);
        ft.play();
        PauseTransition delay = new PauseTransition(Duration.seconds(3.5));
        Stage stage = (Stage) closeButton.getScene().getWindow();
        delay.setOnFinished(events -> stage.close());
        delay.play();
    }
}
