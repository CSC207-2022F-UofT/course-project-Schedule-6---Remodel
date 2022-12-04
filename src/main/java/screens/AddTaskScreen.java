package screens;

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
    private Button taskAdd;

    @FXML
    private DatePicker taskDate;

    @FXML
    private TextField taskDescription;

    @FXML
    private Label errorMessage;


    public void addTask(ActionEvent event) {
     
    }

    public void cancelTask(ActionEvent actionEvent) {
        Stage stage = (Stage) taskCancel.getScene().getWindow();
        stage.close();
    }
}
