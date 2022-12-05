package controller.User;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import database.MongoDBAccess;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.net.UnknownHostException;
import main.collectCollection;

public class UserRegisterController {

    public void cancelButtonAction(ActionEvent event, Button RGclosebutton) {
        Stage stage = (Stage) RGclosebutton.getScene().getWindow();
        stage.close();
    }
    public void registerButtonOnAction(ActionEvent event, Label registrationMessage, Label passwordMisMatch,
                                       TextField RGfirstname, TextField RGlastname, TextField RGusername,
                                       TextField RGpassword, TextField RGconfirmpassword,
                                       Button RGclosebutton, Label inuselabel) throws UnknownHostException {
        if (RGfirstname.getText().isBlank() || RGlastname.getText().isBlank() || RGusername.getText().isBlank() ||
                RGpassword.getText().isBlank() || RGconfirmpassword.getText().isBlank()) {
            registrationMessage.setText("PLEASE FILL IN ALL FIELDS");
            FadeTransition ft = new FadeTransition(Duration.millis(3125), registrationMessage);
            ft.setFromValue(1.0);
            ft.setToValue(0.0);
            ft.setAutoReverse(true);
            ft.play();
        } else {
            if (RGpassword.getText().equals(RGconfirmpassword.getText())) {
                registerUser(registrationMessage, passwordMisMatch,
                        RGfirstname, RGlastname, RGusername,
                        RGpassword, RGclosebutton, inuselabel);
            } else {
                passwordMisMatch.setText("PASSWORDS DO NOT MATCH");
                FadeTransition ft = new FadeTransition(Duration.millis(3125), passwordMisMatch);
                ft.setFromValue(1.0);
                ft.setToValue(0.0);
                ft.setAutoReverse(true);
                ft.play();
            }
        }
    }
    public void registerUser(Label registrationMessage, Label passwordMisMatch,
                              TextField RGfirstname, TextField RGlastname, TextField RGusername,
                              TextField RGpassword, Button RGclosebutton, Label inuselabel) throws UnknownHostException {

        DBCollection collection = collectCollection.main();
        MongoDBAccess client = new MongoDBAccess(collection, RGusername.getText());
        String firstName_ = RGfirstname.getText();
        String lastName_ = RGlastname.getText();
        String username_ = RGusername.getText();
        String password_ = RGpassword.getText();

        if(client.createUser(password_, firstName_, lastName_)){
            registrationMessage.setText("USER REGISTRATION SUCCESSFUL");
            PauseTransition delay = new PauseTransition(Duration.seconds(4.5));
            Stage stage = (Stage) RGclosebutton.getScene().getWindow();
            delay.setOnFinished( event -> stage.close() );
            delay.play();
            passwordMisMatch.setText("");
        }
        else{
            inuselabel.setText("USERNAME IN USE");
        }

    }

}