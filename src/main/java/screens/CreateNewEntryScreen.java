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
