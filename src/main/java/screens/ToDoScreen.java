package screens;

import entity.Task.CommonTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;

import java.time.LocalDate;
import java.util.ResourceBundle;

public class ToDoScreen {

    @FXML
    private TableColumn<CommonTask, String> taskDescription;

    @FXML
    private TableColumn<CommonTask, LocalDate> taskDate;

    @FXML
    private TableColumn<CommonTask, String> taskCategory;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button todoAddButton;

    @FXML
    private TableView<CommonTask> todoTable;

    @FXML
    private Button deleteTaskButton;

    @FXML
    private Button editTaskButton;

    @FXML
    private Button taskAdd;

    public void initialize(){
        TableView.TableViewSelectionModel<CommonTask> selectionModel = todoTable.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);

        taskDescription.setCellValueFactory(new PropertyValueFactory<CommonTask, String>("description"));
        taskDate.setCellValueFactory(new PropertyValueFactory<CommonTask, LocalDate>("date"));
        taskCategory.setCellValueFactory(new PropertyValueFactory<CommonTask, String>("category"));
        //LocalDate date = LocalDate.of(2020, 1, 8);
        //todoTable.getItems().add(new CommonTask("a", date, false, "a"));
        //todoTable.getItems().add(new CommonTask("a", date, false, "a"));
        //todoTable.getItems().add(new CommonTask("a", date, false, "a"));

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

