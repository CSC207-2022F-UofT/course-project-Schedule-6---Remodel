package controller.Task;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TodoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addCategoryButton;

    @FXML
    private Button addTaskButton;


    @FXML
    public void addCategoryButtonAction(ActionEvent event) {
        //createCategoryForm.newForm();

    }

    @FXML
    public void addTaskButtonAction(ActionEvent event) {
       //createTaskForm.newForm();
    }

}
