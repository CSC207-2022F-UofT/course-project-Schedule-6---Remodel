package screens;

import controller.Task.ToDoController;
import entity.Task.CommonTask;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;

import java.util.ResourceBundle;

public class ToDoScreen {

    @FXML
    private TableColumn<CommonTask, String> taskDescription;

    @FXML
    private TableColumn<CommonTask, String> taskDate;

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
        todoTable.setEditable(true);
        TableView.TableViewSelectionModel<CommonTask> selectionModel = todoTable.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);

        taskDescription.setCellValueFactory(new PropertyValueFactory<CommonTask, String>("description"));
        taskDate.setCellValueFactory(new PropertyValueFactory<CommonTask, String>("date"));
        taskCategory.setCellValueFactory(new PropertyValueFactory<CommonTask, String>("category"));

        taskDescription.setCellFactory(TextFieldTableCell.forTableColumn());
        taskDate.setCellFactory(TextFieldTableCell.forTableColumn());
        taskCategory.setCellFactory(TextFieldTableCell.forTableColumn());

        taskDescription.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<CommonTask, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<CommonTask, String> event) {
                CommonTask task = event.getRowValue();
                task.setDescription(event.getNewValue());
            }
        });

        taskDate.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<CommonTask, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<CommonTask, String> event) {
                CommonTask task = event.getRowValue();
                task.setDate(event.getNewValue());
            }
        });

        taskCategory.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<CommonTask, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<CommonTask, String> event) {
                CommonTask task = event.getRowValue();
                task.setCategory(event.getNewValue());
            }
        });


//        LocalDate date = LocalDate.of(2022, 12, 5);
//        LocalDate date2 = LocalDate.of(2022, 12, 16);
//        LocalDate date3 = LocalDate.of(2022, 12, 13);
//        LocalDate date4 = LocalDate.of(2022, 12, 5);
        todoTable.getItems().add(new CommonTask("Project Presentation", "2022-12-08", "CSC207"));
        todoTable.getItems().add(new CommonTask("Final Exam", "2022-12-09", "CSC207"));
        todoTable.getItems().add(new CommonTask("Buy cat food", "2022-12-06", "Pet"));
        todoTable.getItems().add(new CommonTask("Send work schedule", "2022-12-03", "Work"));

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