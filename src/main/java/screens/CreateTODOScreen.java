package screens;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.ScheduleButton;

public class CreateTODOScreen {

    public static void newForm() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ScheduleButton.class.getClassLoader().getResource
                    ("todo.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 700);
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
