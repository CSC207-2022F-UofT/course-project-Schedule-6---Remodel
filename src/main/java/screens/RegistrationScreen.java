package screens;

import controller.User.UserRegisterController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.UnknownHostException;

public class RegistrationScreen {
    @FXML
    public Button RGclosebutton;
    @FXML
    private TextField RGfirstname;
    @FXML
    private TextField RGlastname;
    @FXML
    private TextField RGusername;
    @FXML
    private TextField RGpassword;
    @FXML
    private TextField RGconfirmpassword;
    @FXML
    private Label registrationMessage;
    @FXML
    private Label inUseLabel;
    @FXML
    private Label passwordMisMatch;

    private final UserRegisterController userRegisterController = new UserRegisterController();
    public void cancelButtonAction(ActionEvent event) {
        userRegisterController.cancelButtonAction(event, RGclosebutton);}
    public void registerButtonOnAction(ActionEvent event) throws UnknownHostException {
        userRegisterController.registerButtonOnAction(event, registrationMessage, inUseLabel, passwordMisMatch,
                RGfirstname, RGlastname, RGusername, RGpassword, RGconfirmpassword, RGclosebutton);
    }
}

