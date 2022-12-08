package controller.User;


import boundary.User.UserLoginInputBoundary;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presenter.UserLoginPresenter;
import requestModel.UserLoginRequestModel;
import screens.CreateRegistrationScreen;
import java.net.UnknownHostException;

import useCaseInteractor.DataAccess;
import database.MongoDBAccess;
import main.collectCollection;
import useCaseInteractor.User.UserLogin;

public class MainController {

    public void cancelButtonAction(ActionEvent event, Button cancelButton){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void loginButtonAction(ActionEvent event, TextField usernameTextField, TextField passwordTextField,
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

    public void registerButtonAction(ActionEvent event){
        CreateRegistrationScreen.newForm();}
}