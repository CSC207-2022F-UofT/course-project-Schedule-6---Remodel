package screens;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.Main;

public class CreateTimetableScreen {

    public static void newForm() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getClassLoader().getResource
                    ("Timetable.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1500, 700);
            Stage timetableStage = new Stage();
            timetableStage.setResizable(false);
            timetableStage.initStyle(StageStyle.DECORATED);
            timetableStage.setScene(scene);
            timetableStage.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}