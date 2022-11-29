package controller.User;


import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import entity.User.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import screens.CreateRegistrationScreen;
import useCaseInteractor.Schedule.createScheduleForm;

import java.net.UnknownHostException;
import useCaseInteractor.User.setUsername;
import useCaseInteractor.User.userCollection;
import database.MongoDBAccess;

public class LoginPageController {
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


    public void cancelButtonAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    public void loginButtonAction(ActionEvent event) throws UnknownHostException {

        if (!usernameTextField.getText().isBlank() && !passwordTextField.getText().isBlank()) {
            User loginAttempt = this.main();
            if (loginAttempt != null){

                //If the Login is successful then the window closes
                loginMessageLabel.setText("LOGIN SUCCESSFUL");
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.close();
                //Username of the person logged in is Stored in the user collector
                userCollection.setUser(loginAttempt);
                //The schedule form opens
                createScheduleForm.newForm();
                setUsername.setName();
            }
            if (loginAttempt == null) {
                loginMessageLabel.setText("USERNAME OR PASSWORD INCORRECT");
            }
        } else {
            loginMessageLabel.setText("PLEASE ENTER A USERNAME AND PASSWORD");
        }

    }
    public void registerButtonAction(ActionEvent event){
        CreateRegistrationScreen.newForm();}


    public User login(DBCollection collection){
        User user = null;

        MongoDBAccess client = new MongoDBAccess(collection, usernameTextField.getText());
        System.out.println(client.getUserExist(usernameTextField.getText()));
        System.out.println(client.checkPassword(passwordTextField.getText()));


        if(client.getUserExist(usernameTextField.getText()) && client.checkPassword(passwordTextField.getText())){
            user = new User();
            user.username = usernameTextField.getText();
            user.password = passwordTextField.getText();
        }
        System.out.println(user);
        return user;

    }

    public User main() throws UnknownHostException {

        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://stevenli:stevenli@cluster0.koruj0t.mongodb.net/?retryWrites=true&w=majority"));
        DB database = mongoClient.getDB("schedule6-testingdb");
        DBCollection collection = database.getCollection("schedule6-testingcollection");
        System.out.println(1);
        return this.login(collection);
    }
}