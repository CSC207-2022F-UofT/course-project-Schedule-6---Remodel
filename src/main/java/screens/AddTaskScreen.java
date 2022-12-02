package screens;

import controller.Task.TaskCreationController;
import database.MongoDBAccess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class AddTaskScreen {
    public Button taskCancelButton;

    public Label taskError;
    @FXML
    private ComboBox<?> categoryComboBox;

    @FXML
    private ComboBox<String> privacyComboBox;

    @FXML
    private Button taskCreateAddButton;

    @FXML
    private DatePicker taskDate;

    @FXML
    private TextField taskDescription;

    @FXML
    public TableView todoTable;

    private final TaskCreationController taskCreationController;

    public AddTaskScreen(TaskCreationController controller){
        this.taskCreationController = controller;
    }


    @FXML
    public void addTask(ActionEvent event) {
        taskCreationController.create(taskDescription.getText(), taskDate.getValue(), true, (String) categoryComboBox.getValue());
        Stage stage = (Stage) taskCreateAddButton.getScene().getWindow();
        stage.close();

    }



    public void taskCancelAction(ActionEvent actionEvent) {
        Stage stage = (Stage) taskCancelButton.getScene().getWindow();
        stage.close();
    }
}
