package screens;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.Objects;

public class AddTaskScreen {
    public Button taskCancelButton;

    public Label taskError;
    @FXML
    private ComboBox<?> categoryComboBox;

    @FXML
    private ComboBox<?> privacyComboBox;

    @FXML
    private Button taskCreateAddButton;

    @FXML
    private DatePicker taskDate;

    @FXML
    private TextField taskTitle;

    @FXML
    public TableView todoTable;

    @FXML
    public void addTask(ActionEvent event) {
        String title_ = (String) taskTitle.getText();
        LocalDate date_ = taskDate.getValue();
        Boolean isPrivate_ = Objects.equals((java.lang.String) privacyComboBox.getValue(), "Private");

        //Category category_ = categoryComboBox.
    }



    public void taskCancelAction(ActionEvent actionEvent) {
        Stage stage = (Stage) taskCancelButton.getScene().getWindow();
        stage.close();
    }
}
