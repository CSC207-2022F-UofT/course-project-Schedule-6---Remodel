package useCaseInteractor.Category;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.TodoPage;

import java.io.IOException;
import java.net.URL;

public class createCategoryForm {
    public static void newForm() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(TodoPage.class.getClassLoader().getResource("CategoryCreate.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 300);
            Stage categoryStage = new Stage();
            categoryStage.initStyle(StageStyle.DECORATED);
            categoryStage.setScene(scene);
            categoryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}
