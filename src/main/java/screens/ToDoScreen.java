package screens;

import entity.Task.CommonTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;

import java.util.ResourceBundle;

public class ToDoScreen {

    @FXML
    private TableColumn taskTitle;

    @FXML
    private TableColumn taskDate;

    @FXML
    private TableColumn taskCategory;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button todoAddButton;

    @FXML
    private TableView todoTable;

    @FXML
    private Button deleteTaskButton;

    @FXML
    private Button editTaskButton;

    @FXML
    private Button taskAdd;

    public void initialize(){
        TableView.TableViewSelectionModel selectionModel = todoTable.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
    }

    public void todoAddAction(ActionEvent actionEvent) {
        CreateAddTaskScreen.newForm();
    }

    public void todoEditButton(ActionEvent actionEvent) {
        CommonTask selectedItem = (CommonTask) todoTable.getSelectionModel().getSelectedItem();
        CreateEditTaskScreen.newForm();

    }

    public void todoDeleteButton(ActionEvent actionEvent) {
        CommonTask selectedItem = (CommonTask) todoTable.getSelectionModel().getSelectedItem();
        todoTable.getItems().remove(selectedItem);
    }

}

