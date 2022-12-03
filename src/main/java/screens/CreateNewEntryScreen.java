package screens;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.ScheduleButton;

public class CreateNewEntryScreen {
    public static void newForm() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ScheduleButton.class.getClassLoader().getResource
                    ("ScheduleInputs.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400 , 455);
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
