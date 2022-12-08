package screens;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.Main;

public class CreateRegistrationScreen {

    public static void newForm() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getClassLoader().getResource(
                    "RegistrationPage.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 468, 600);
            Stage registrationStage = new Stage();
            registrationStage.setResizable(false);
            registrationStage.initStyle(StageStyle.DECORATED);
            registrationStage.setScene(scene);
            registrationStage.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}