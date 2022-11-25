//package controller;
//
//
//import entity.User;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.stage.Stage;
//import main.DataConnection;
//import useCaseInteractor.User.createAccountForm;
//import useCaseInteractor.Schedule.createScheduleForm;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import useCaseInteractor.User.setUsername;
//import useCaseInteractor.User.userCollection;
//
//public class LoginPageController {
//    @FXML
//    private Button cancelButton;
//    @FXML
//    private Label loginMessageLabel;
//    @FXML
//    private TextField usernameTextField;
//    @FXML
//    private TextField passwordTextField;
//    @FXML
//    private Button loginButton;
//
//
//    public void cancelButtonAction(ActionEvent event){
//        Stage stage = (Stage) cancelButton.getScene().getWindow();
//        stage.close();
//    }
//    public void loginButtonAction(ActionEvent event){
//
//        if (!usernameTextField.getText().isBlank() && !passwordTextField.getText().isBlank()) {
//            User loginAttempt = Login();
//            if (loginAttempt != null){
//
//                //If the Login is successful then the window closes
//                loginMessageLabel.setText("LOGIN SUCCESSFUL");
//                Stage stage = (Stage) loginButton.getScene().getWindow();
//                stage.close();
//
//                //Username of the person logged in is Stored in the user collector
//                userCollection.setUser(loginAttempt);
//                //The schedule form opens
//                createScheduleForm.newForm();
//                setUsername.setName();
//                System.out.println("Successful Authentication of: " + loginAttempt.username);
//                System.out.println("           First name: " + loginAttempt.firstname);
//                System.out.println("           Last name: " + loginAttempt.lastname);
//
//            }
//            else {
//                loginMessageLabel.setText("USERNAME OR PASSWORD INCORRECT");
//            }
//        } else {
//            loginMessageLabel.setText("PLEASE ENTER A USERNAME AND PASSWORD");
//        }
//
//    }
//    public void registerButtonAction(ActionEvent event){createAccountForm.newForm();}
//
//
//    public  User Login() {
//        User user = null;
//        DataConnection connection = new DataConnection();
//        Connection connectionDataBase = connection.getConnection();
//
//        String verifyLogin = "SELECT * FROM useraccounts WHERE username=? AND password=?";
//
//        try {
//            Statement statement = connectionDataBase.createStatement();
//            PreparedStatement preparedStatement = connection.databaseuser.prepareStatement(verifyLogin);
//            preparedStatement.setString(1, usernameTextField.getText());
//            preparedStatement.setString(2, passwordTextField.getText());
//
//            ResultSet results = preparedStatement.executeQuery();
//
//            if (results.next()) {
//                user = new User();
//                user.firstname = results.getString("firstname");
//                user.lastname = results.getString("lastname");
//                user.username = results.getString("username");
//                user.password = results.getString("password");
//            }
//            statement.close();
//            connectionDataBase.close();
//
//        } catch (Exception e) {
//            System.out.println(connection);
//            e.printStackTrace();
//            e.getCause();
//        }
//
//        return user;
//    }
//}