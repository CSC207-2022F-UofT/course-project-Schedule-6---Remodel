package screens;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditTaskScreen {

    @FXML
    private Button editCancelButton;

    @FXML
    private ComboBox<?> newCategoryComboBox;

    @FXML
    private DatePicker newDate;

    @FXML
    private TextField newDescription;

    @FXML
    private Button taskEditButton;

    @FXML
    void editButtonAction(ActionEvent event) {

    }

    @FXML
    void editCancelAction(ActionEvent event) {
        Stage stage = (Stage) editCancelButton.getScene().getWindow();
        stage.close();

    }
}
