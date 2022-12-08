package screens;

import controller.User.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.UnknownHostException;

public class MainScreen {
    @FXML
    public Button registerButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Button loginButton;

    private final MainController mainController = new MainController();

    public void cancelButtonAction(ActionEvent event) {
        mainController.cancelButtonAction(cancelButton);
    }

    public void loginButtonAction(ActionEvent event) throws UnknownHostException {
        mainController.loginButtonAction(usernameTextField, passwordTextField, loginButton, loginMessageLabel);
    }

    public void registerButtonAction(ActionEvent event) {
        mainController.registerButtonAction();
    }
}
