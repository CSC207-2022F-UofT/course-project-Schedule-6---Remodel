package controller.User;

import boundary.User.UserRegisterInputBoundary;
import database.MongoDBAccess;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.net.UnknownHostException;
import main.collectCollection;
import presenter.UserRegisterPresenter;
import requestModel.UserRegisterRequestModel;
import useCaseInteractor.DataAccess;
import useCaseInteractor.User.UserRegister;

public class UserRegisterController {

    private final UserRegisterPresenter presenter = new UserRegisterPresenter();

    public UserRegisterController() {
    }

    public void cancelButtonAction(ActionEvent event, Button RGclosebutton) {
        Stage stage = (Stage) RGclosebutton.getScene().getWindow();
        stage.close();
    }
    public void registerButtonOnAction(ActionEvent event,
                                       Label registrationMessage, Label inUseLabel, Label passwordMisMatch,
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
                        RGpassword.getText(), RGconfirmpassword.getText(), RGfirstname.getText(), RGlastname.getText());
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