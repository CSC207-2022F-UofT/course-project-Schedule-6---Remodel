package controller.User;

import boundary.User.UserRegisterInputBoundary;
import database.MongoDBAccess;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.collectCollection;
import presenter.UserRegisterPresenter;
import requestModel.UserRegisterRequestModel;
import useCaseInteractor.DataAccess;
import useCaseInteractor.User.UserRegister;

import java.net.UnknownHostException;

public class UserRegisterController {

    private final UserRegisterPresenter presenter = new UserRegisterPresenter();

    public UserRegisterController() {
    }

    /**
     * When the cancel button is clicked, the registration screen will close
     *
     * @param RGclosebutton a button on the registration screen
     */
    public void cancelButtonAction(Button RGclosebutton) {
        Stage stage = (Stage) RGclosebutton.getScene().getWindow();
        stage.close();
    }

    /**
     * Once the user fills in the textfields, this method will be called when the user clicks the Register button
     * Has input checkers to check basic inputs that the controller can see such as missing input fields or
     * if the passwords doesn't match.
     * <p>
     * If all the inputs are filled out, username doesn't exist, and passwords match, the UserRegister use case
     * will be called
     *
     * @param registrationMessage text label to display a message
     * @param inUseLabel          text label to tell the user that this RGusername is already in use
     * @param passwordMisMatch    text label to tell the user that the passwords does not match
     * @param RGfirstname         inputted first name
     * @param RGlastname          inputted last name
     * @param RGusername          inputted username
     * @param RGpassword          inputted password
     * @param RGconfirmpassword   inputted repeated password
     * @param RGclosebutton       close screen button
     */
    public void registerButtonOnAction(Label registrationMessage, Label inUseLabel, Label passwordMisMatch,
                                       TextField RGfirstname, TextField RGlastname, TextField RGusername,
                                       TextField RGpassword, TextField RGconfirmpassword,
                                       Button RGclosebutton) throws UnknownHostException {
        if (RGfirstname.getText().isBlank() || RGlastname.getText().isBlank() || RGusername.getText().isBlank() ||
                RGpassword.getText().isBlank() || RGconfirmpassword.getText().isBlank()) {
            presenter.registrationMessage(registrationMessage, "PLEASE FILL IN ALL FIELDS");
        } else {
            DataAccess dataAccess = new MongoDBAccess(collectCollection.main(), RGusername.getText());

            if (dataAccess.getUserExist(RGusername.getText())) {
                presenter.registrationMessage(inUseLabel, "USERNAME IN USE");
            } else if (RGpassword.getText().equals(RGconfirmpassword.getText())) {

                UserRegisterRequestModel requestModel = new UserRegisterRequestModel(RGusername.getText(),
                        RGpassword.getText(), RGfirstname.getText(), RGlastname.getText());
                UserRegisterInputBoundary inputBoundary = new UserRegister(dataAccess);
                inputBoundary.create(requestModel);
                presenter.prepeareSuccessAction(
                        registrationMessage, "USER REGISTRATION SUCCESSFUL", RGclosebutton);
            } else {
                presenter.registrationMessage(passwordMisMatch, "PASSWORDS DO NOT MATCH");
            }
        }
    }
}