package controller.User;


import boundary.User.loadUserScheduleInputBoundary;
import controller.Schedule.TimetableController;
import entity.User.CommonUser;
import entity.User.User;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import screens.CreateRegistrationScreen;
import screens.CreateScheduleScreen;
import java.net.UnknownHostException;

import screens.TimeTableScreen;
import useCaseInteractor.DataAccess;
import useCaseInteractor.User.loadUserSchedule;
import useCaseInteractor.User.setUsername;
import useCaseInteractor.User.userCollection;
import database.MongoDBAccess;
import main.collectCollection;

public class LoginPageController {

    public void cancelButtonAction(ActionEvent event, Button cancelButton){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    public void loginButtonAction(ActionEvent event, TextField usernameTextField, TextField passwordTextField,
                                  Button loginButton, Label loginMessageLabel) throws UnknownHostException {

        if (!usernameTextField.getText().isBlank() && !passwordTextField.getText().isBlank()) {
            User loginAttempt = this.login(usernameTextField, passwordTextField);
            if (loginAttempt != null){

                //If the Login is successful then the window closes
                loginMessageLabel.setText("LOGIN SUCCESSFUL");
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.close();
                //Username of the person logged in is Stored in the user collector
                userCollection.setUser(loginAttempt);
                //The schedule form opens
                CreateScheduleScreen.newForm();
                setUsername.setName();
            }
            if (loginAttempt == null) {
                loginMessageLabel.setText("USERNAME OR PASSWORD INCORRECT");
                FadeTransition ft = new FadeTransition(Duration.millis(2850), loginMessageLabel);
                ft.setFromValue(1.0);
                ft.setToValue(0.0);
                ft.setAutoReverse(true);
                ft.play();
            }
        } else {
            loginMessageLabel.setText("PLEASE ENTER A USERNAME AND PASSWORD");
            FadeTransition ft = new FadeTransition(Duration.millis(2850), loginMessageLabel);
            ft.setFromValue(1.0);
            ft.setToValue(0.0);
            ft.setAutoReverse(true);
            ft.play();
        }

    }
    public void registerButtonAction(ActionEvent event){
        CreateRegistrationScreen.newForm();}

    public User login(TextField usernameTextField, TextField passwordTextField) throws UnknownHostException {

        MongoDBAccess client = new MongoDBAccess(collectCollection.main(), usernameTextField.getText());

        if(client.getUserExist(usernameTextField.getText()) && client.checkPassword(passwordTextField.getText())){
            User user = new CommonUser(usernameTextField.getText(), passwordTextField.getText());
            return user;
        }
        return null;
    }
}