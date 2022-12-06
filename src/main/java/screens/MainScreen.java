package screens;

import controller.Schedule.ScheduleController;
import controller.User.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.UnknownHostException;

public class MainScreen {
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

    private final ScheduleController scheduleController = new ScheduleController();

    public void cancelButtonAction(ActionEvent event) {
        mainController.cancelButtonAction(event, cancelButton);}
    public void loginButtonAction(ActionEvent event) throws UnknownHostException {
        mainController.loginButtonAction(event, usernameTextField, passwordTextField, loginButton, loginMessageLabel);
        scheduleController.loadSchedule();
    }
    public void registerButtonAction(ActionEvent event){
        mainController.registerButtonAction(event);}
}
