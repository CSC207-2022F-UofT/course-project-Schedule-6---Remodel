package controller.User;


import boundary.User.UserLoginInputBoundary;
import database.MongoDBAccess;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.collectCollection;
import presenter.UserLoginPresenter;
import requestModel.UserLoginRequestModel;
import screens.CreateRegistrationScreen;
import useCaseInteractor.DataAccess;
import useCaseInteractor.User.UserLogin;

import java.net.UnknownHostException;

public class MainController {

    /**
     * When the cancel button is clicked, the login screen will close and program will stop running
     *
     * @param cancelButton close button on the login screen
     */
    public void cancelButtonAction(Button cancelButton) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    /**
     * When user fills in the fields and clicks the login button, this method will be called.
     * Will check if the input fields are filled, if the user exists in the database, and if
     * the username and password match
     *
     * @param usernameTextField user inputted username
     * @param passwordTextField user inputted password
     * @param loginButton       login button
     * @param loginMessageLabel text label to display a message on the screen
     */
    public void loginButtonAction(TextField usernameTextField, TextField passwordTextField,
                                  Button loginButton, Label loginMessageLabel) throws UnknownHostException {

        DataAccess dataAccess = new MongoDBAccess(collectCollection.main(), usernameTextField.getText());
        UserLoginPresenter presenter = new UserLoginPresenter(loginMessageLabel, loginButton);

        if (usernameTextField.getText().isBlank() || passwordTextField.getText().isBlank()) {
            presenter.loginMessage(loginMessageLabel, "PLEASE ENTER A USERNAME AND PASSWORD");
        } else {
            UserLoginRequestModel requestModel = new UserLoginRequestModel(usernameTextField.getText(),
                    passwordTextField.getText());
            UserLoginInputBoundary inputBoundary = new UserLogin(dataAccess, requestModel, presenter);
            userCollection.setUser(usernameTextField.getText());
            inputBoundary.loginCheck();
        }
    }

    /**
     * Called when the user clicks the registration button
     */
    public void registerButtonAction() {
        CreateRegistrationScreen.newForm();
    }
}