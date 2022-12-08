package screens;

import controller.Task.TaskController;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Duration;

import java.net.UnknownHostException;
import java.util.Map;

public class TaskScreen {
    @FXML
    public Button deleteTaskButton;
    @FXML
    public Button saveButton;
    @FXML
    public Button taskAdd;
    @FXML
    private TableColumn<Map, String> taskDescription = new TableColumn<>("Description");

    @FXML
    private TableColumn<Map, String> taskDate = new TableColumn<>("Date");

    @FXML
    private TableColumn<Map, String> taskCategory = new TableColumn<>("Category");

    @FXML
    private TextField newTaskDescription;
    @FXML
    private TextField newTaskCategory;
    @FXML
    private TextField newTaskDate;

    @FXML
    private TableView<Map> todoTable;

    @FXML
    private Label errorMessage;

    private final TaskController taskController = new TaskController();

    public void initialize() throws UnknownHostException {
        todoTable.setEditable(true);
        TableView.TableViewSelectionModel<Map> selectionModel = todoTable.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);

        taskDescription.setCellValueFactory(new MapValueFactory<>("Description"));
        taskDate.setCellValueFactory(new MapValueFactory<>("Date"));
        taskCategory.setCellValueFactory(new MapValueFactory<>("Category"));

        taskDescription.setCellFactory(TextFieldTableCell.forTableColumn());
        taskCategory.setCellFactory(TextFieldTableCell.forTableColumn());
        taskDate.setCellFactory(TextFieldTableCell.forTableColumn());


        taskDescription.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Map, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Map, String> t) {
                        t.getTableView().getItems().get(t.getTablePosition().getRow()).replace(
                                "Description", t.getOldValue(), t.getNewValue());
                    }
                });
        taskDate.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Map, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Map, String> t) {
                        if (taskController.checkFormat(t.getNewValue())) {
                            t.getTableView().getItems().get(t.getTablePosition().getRow()).replace(
                                    "Date", t.getOldValue(), t.getNewValue());
                        } else {
                            errorMessage.setText("ENTER DATE IN FORMAT YYYY-MM-DD");
                            FadeTransition ft = new FadeTransition(Duration.millis(2850), errorMessage);
                            ft.setFromValue(1.0);
                            ft.setToValue(0.0);
                            ft.setAutoReverse(true);
                            ft.play();
                        }
                    }
                });
        taskCategory.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Map, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Map, String> t) {
                        t.getTableView().getItems().get(t.getTablePosition().getRow()).replace(
                                "Category", t.getOldValue(), t.getNewValue());
                    }
                });
        taskController.loadTasks(todoTable);
    }

    public void todoAddAction(ActionEvent actionEvent) {
        //Code that takes the data and makes a new event
        taskController.addNewEntry(todoTable, newTaskDescription, newTaskDate, newTaskCategory, errorMessage);
    }

    public void saveFromTable(ActionEvent actionEvent) throws UnknownHostException {
        taskController.saveTaskEntries(todoTable, errorMessage);
    }

    public void todoDeleteButton(ActionEvent actionEvent) {
        todoTable.getItems().remove(todoTable.getSelectionModel().getSelectedItem());
    }
}