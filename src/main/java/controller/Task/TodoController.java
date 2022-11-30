package controller.Task;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import useCaseInteractor.Category.createCategoryForm;
import useCaseInteractor.Task.createTaskForm;

public class TodoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addCategoryButton;

    @FXML
    private Button addTaskButton;

    public void todoAddButtonAction(ActionEvent actionEvent) {
        createTaskForm.newForm();
    }

    public void todoAddCategory(ActionEvent actionEvent) {
        createCategoryForm.newForm();
    }
}
