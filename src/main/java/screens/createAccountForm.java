package screens;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.LoginPage;

public class createAccountForm {

    public static void newForm() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(LoginPage.class.getClassLoader().getResource("Register.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 468, 600);
            Stage loginStage = new Stage();
            loginStage.initStyle(StageStyle.DECORATED);
            loginStage.setScene(scene);
            loginStage.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}