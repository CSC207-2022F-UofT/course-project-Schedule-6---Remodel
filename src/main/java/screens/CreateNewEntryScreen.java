package screens;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.Main;

public class CreateNewEntryScreen {
    public static void newForm() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getClassLoader().getResource
                    ("FutureEvents.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 336 , 488);
            Stage createFutureEventStage = new Stage();
            createFutureEventStage.setResizable(false);
            createFutureEventStage.initStyle(StageStyle.DECORATED);
            createFutureEventStage.setScene(scene);
            createFutureEventStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}
