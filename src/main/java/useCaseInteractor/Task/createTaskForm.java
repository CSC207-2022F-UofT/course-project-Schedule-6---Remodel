package useCaseInteractor.Task;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.TodoPage;

import java.io.IOException;
import java.net.URL;

public class createTaskForm{
    public static void newForm() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(TodoPage.class.getClassLoader().getResource("TaskCreate.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 450);
            Stage taskStage = new Stage();
            taskStage.initStyle(StageStyle.DECORATED);
            taskStage.setScene(scene);
            taskStage.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

}