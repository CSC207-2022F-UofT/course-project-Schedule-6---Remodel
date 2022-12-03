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
    public Button taskCancel;

    @FXML
    private TextField taskCategory;

    @FXML
    private ComboBox<String> privacyComboBox;

    @FXML
    private Button taskAdd;

    @FXML
    private DatePicker taskDate;

    @FXML
    private TextField taskDescription;

    @FXML
    private Label errorMessage;

    private final TaskCreationController taskCreationController;

    public AddTaskScreen(TaskCreationController controller){
        this.taskCreationController = controller;
    }


    @FXML
    public void addTask(ActionEvent event) {
        taskCreationController.create(taskDescription.getText(), taskDate.getValue(), true, taskCategory.getText());

    }

    public void cancelTask(ActionEvent actionEvent) {
        Stage stage = (Stage) taskCancel.getScene().getWindow();
        stage.close();
    }
}
