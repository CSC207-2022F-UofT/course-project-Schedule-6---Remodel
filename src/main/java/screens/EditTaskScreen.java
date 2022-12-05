package screens;

import controller.Task.EditTaskController;
import entity.Task.CommonTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class EditTaskScreen {

    @FXML
    private Button editCancelButton;

    @FXML
    private TextField newCategory;

    @FXML
    private DatePicker newDate;

    @FXML
    private TextField newDescription;

    @FXML
    private Button taskEditButton;

    //private EditTaskController ETC = new EditTaskController();
    private ToDoScreen TDS = new ToDoScreen();

    public void initialize(){
//        CommonTask oldTask = TDS.getSelectedItem();
//        newCategory.setText(oldTask.getCategory());
//        newDate.setText(oldTask.getDate());
//        newDescription.setText(oldTask.getDescription());

    }
    @FXML
    public void editButtonAction(ActionEvent event) {
        // call the screen ToDoScreen
        CommonTask CT = TDS.getSelectedItem();
        if (CT != null) {
            String oldDescription = CT.getDescription();
            //LocalDate oldDate = CT.getDate();
            String oldCategory = CT.getCategory();
        }
        //ETC.(newDescription.getText(), newDate.getValue(), newCategory.getText(), oldDescription, oldDate, oldCategory)

    }

    @FXML
    public void editCancelAction(ActionEvent event) {
        Stage stage = (Stage) editCancelButton.getScene().getWindow();
        stage.close();

    }
}
