package controller.User;

import javafx.animation.PauseTransition;
import javafx.util.Duration;
import main.DataConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class UserRegisterController {
    @FXML
    private Button RGregisterbutton;
    @FXML
    private Button RGclosebutton;
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
    private Label inuselabel;
    @FXML
    private Label passwordMisMatch;

    public void cancelButtonAction(ActionEvent event) {
        Stage stage = (Stage) RGclosebutton.getScene().getWindow();
        stage.close();
    }
    public void registerButtononAction(ActionEvent event) {
        registrationMessage.setText("");
        passwordMisMatch.setText("");
        if (RGfirstname.getText().isBlank() || RGlastname.getText().isBlank() || RGusername.getText().isBlank() ||
                RGpassword.getText().isBlank() || RGconfirmpassword.getText().isBlank()) {
            registrationMessage.setText("PLEASE FILL IN ALL FIELDS");
        } else {
            if (RGpassword.getText().equals(RGconfirmpassword.getText())) {
                passwordMisMatch.setText("");
                registerUser();
            } else {
                passwordMisMatch.setText("PASSWORDS DO NOT MATCH");
            }
        }
    }
    public void registerUser() {
        DataConnection connection = new DataConnection();
        Connection connectionDB = connection.getConnection();

        String firstName_ = RGfirstname.getText();
        String lastName_ = RGlastname.getText();
        String username_ = RGusername.getText();
        String password_ = RGpassword.getText();
        try {
            PreparedStatement stmt = connectionDB.prepareStatement
                    ("INSERT INTO useraccounts(firstname, lastname, username, password) VALUE (?, ?, ?, ?)");
            stmt.setString(1, firstName_);
            stmt.setString(2, lastName_);
            stmt.setString(3, username_);
            stmt.setString(4, password_);
            stmt.executeUpdate();
            registrationMessage.setText("USER REGISTRATION SUCCESSFUL");
            PauseTransition delay = new PauseTransition(Duration.seconds(4.5));
            Stage stage = (Stage) RGclosebutton.getScene().getWindow();
            delay.setOnFinished( event -> stage.close() );
            delay.play();
            passwordMisMatch.setText("");
        } catch (Exception e) {
            inuselabel.setText("USERNAME IN USE");
            e.printStackTrace();
            e.getCause();
        }
    }


}