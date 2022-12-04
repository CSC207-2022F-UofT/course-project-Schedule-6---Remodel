package screens;

import controller.Task.ToDoController;
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

    private ToDoController controller = new ToDoController();

    public void initialize() {
        TableView.TableViewSelectionModel<CommonTask> selectionModel = todoTable.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);

        taskDescription.setCellValueFactory(new PropertyValueFactory<CommonTask, String>("description"));
        taskDate.setCellValueFactory(new PropertyValueFactory<CommonTask, LocalDate>("date"));
        taskCategory.setCellValueFactory(new PropertyValueFactory<CommonTask, String>("category"));
        LocalDate date = LocalDate.of(2022, 12, 5);
        LocalDate date2 = LocalDate.of(2022, 12, 16);
        LocalDate date3 = LocalDate.of(2022, 12, 13);
        LocalDate date4 = LocalDate.of(2022, 12, 5);
        todoTable.getItems().add(new CommonTask("Project Presentation", date, "CSC207"));
        todoTable.getItems().add(new CommonTask("Final Exam", date2, "CSC207"));
        todoTable.getItems().add(new CommonTask("Buy cat food", date3, "Pet"));
        todoTable.getItems().add(new CommonTask("Send manager work schedule", date4, "Work"));



    }


    public void todoAddAction(ActionEvent actionEvent) {
        controller.todoAddAction(actionEvent);
    }

    public void todoEditButton(ActionEvent actionEvent) {
        CommonTask selectedItem = (CommonTask) todoTable.getSelectionModel().getSelectedItem();
        controller.todoEditButton(actionEvent, selectedItem);


    }

    public void todoDeleteButton(ActionEvent actionEvent) {
        CommonTask selectedItem = (CommonTask) todoTable.getSelectionModel().getSelectedItem();
        todoTable.getItems().remove(selectedItem);
    }

    public CommonTask getSelectedItem() {
        if (!todoTable.getItems().isEmpty()) {
            return (CommonTask) todoTable.getSelectionModel().getSelectedItem();
        }

        return null;
    }

}