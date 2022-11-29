package screens;

import controller.User.LoginPageController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.UnknownHostException;

public class LoginScreen {
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

    private LoginPageController LPC = new LoginPageController();

    public void cancelButtonAction(ActionEvent event) {LPC.cancelButtonAction(event, cancelButton);}
    public void loginButtonAction(ActionEvent event) throws UnknownHostException
    {LPC.loginButtonAction(event, usernameTextField, passwordTextField, loginButton, loginMessageLabel);}
    public void registerButtonAction(ActionEvent event){LPC.registerButtonAction(event);}
}
