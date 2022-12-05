package screens;

import controller.Schedule.TimetableController;
import controller.Task.ToDoListController;
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

    private TimetableController TTC = new TimetableController();

    private ToDoListController toDoListController = new ToDoListController();

    public void cancelButtonAction(ActionEvent event) {LPC.cancelButtonAction(event, cancelButton);}
    public void loginButtonAction(ActionEvent event) throws UnknownHostException {
        LPC.loginButtonAction(event, usernameTextField, passwordTextField, loginButton, loginMessageLabel);
        TTC.loadSchedule();
        toDoListController.getAllTasks();
    }
    public void registerButtonAction(ActionEvent event){LPC.registerButtonAction(event);}
}
