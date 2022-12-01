package screens;

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
    private TextField taskTitle;

    @FXML
    public TableView todoTable;

    /*
    private void initialize(){

        ArrayList<ArrayList<Object>> userTasks = db.getUserEntireTask();
        ArrayList<String> categories = new ArrayList<String>();
        for(int i = 0; i < userTasks.size(); i++){
            //categories.add(userTasks.get(i,2));
        }
        //categoryComboBox.getItems().addAll(categories);
    }
    */

    @FXML
    public void addTask(ActionEvent event) {
        String title_ = (String) taskTitle.getText();
        LocalDate date_ = taskDate.getValue();
        String category_ = (String) categoryComboBox.getValue();
    }



    public void taskCancelAction(ActionEvent actionEvent) {
        Stage stage = (Stage) taskCancelButton.getScene().getWindow();
        stage.close();
    }
}
