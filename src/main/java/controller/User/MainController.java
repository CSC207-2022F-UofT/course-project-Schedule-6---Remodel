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

    public void cancelButtonAction(Button cancelButton) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

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

    public void registerButtonAction() {
        CreateRegistrationScreen.newForm();
    }
}