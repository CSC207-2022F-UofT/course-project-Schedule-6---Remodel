package controller.User;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import database.MongoDBAccess;
import entity.User.User;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
import main.DataConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.UnknownHostException;
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
    public void registerButtononAction(ActionEvent event) throws UnknownHostException {
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
    public void registerUser() throws UnknownHostException {

        DBCollection collection = this.main();
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


    public DBCollection main() throws UnknownHostException {

        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://stevenli:stevenli@cluster0.koruj0t.mongodb.net/?retryWrites=true&w=majority"));

        //Brians remote database
//        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://123:123@cluster1.d3e1rhp.mongodb.net/?retryWrites=true&w=majority"));


        DB database = mongoClient.getDB("schedule6-testingdb");
        DBCollection collection = database.getCollection("schedule6-testingcollection");

        System.out.println(1);

        return collection;
    }


}