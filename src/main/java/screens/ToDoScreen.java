package screens;

import boundary.Task.AddTaskItemInputBoundary;
import controller.Task.ToDoController;
import controller.Task.ToDoListController;
import database.MongoDBAccess;
import entity.Task.CommonTask;
import entity.Task.CommonTaskFactory;
import entity.Task.TaskFactory;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Duration;
import main.collectCollection;
import requestModel.TaskRequestModel;
import useCaseInteractor.DataAccess;
import useCaseInteractor.Task.AddTask;
import useCaseInteractor.User.userCollection;

import java.net.URL;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ToDoScreen {

    @FXML
    private TableColumn<CommonTask, String> taskDescription;

    @FXML
    private TableColumn<CommonTask, String> taskDate;

    @FXML
    private TableColumn<CommonTask, String> taskCategory;

    @FXML
    private TextField newTaskDescription;
    @FXML
    private TextField newTaskCategory;
    @FXML
    private TextField newTaskDate;

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
    private Button saveButton;

    @FXML
    private Button taskAdd;

    @FXML
    private Label errorMessage;


    public void initialize() throws UnknownHostException {
        todoTable.setEditable(true);
        TableView.TableViewSelectionModel<CommonTask> selectionModel = todoTable.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);

        taskDescription.setCellValueFactory(new PropertyValueFactory<CommonTask, String>("description"));
        taskDate.setCellValueFactory(new PropertyValueFactory<CommonTask, String>("date"));
        taskCategory.setCellValueFactory(new PropertyValueFactory<CommonTask, String>("category"));

        taskDescription.setCellFactory(TextFieldTableCell.forTableColumn());
        taskCategory.setCellFactory(TextFieldTableCell.forTableColumn());

        taskDescription.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<CommonTask, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<CommonTask, String> t) {
                        ((CommonTask) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setDescription(t.getNewValue());
                    }
                });

        taskCategory.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<CommonTask, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<CommonTask, String> t) {
                        ((CommonTask) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setCategory(t.getNewValue());
                    }
                });



        presentTask();
    }
    private ToDoController TDC = new ToDoController();
    public void todoAddAction(ActionEvent actionEvent) {
        //Code that takes the data and makes a new event
        TDC.addNewEntry(todoTable, newTaskDescription, newTaskDate, newTaskCategory, errorMessage);
    }

    public void saveFromTable(ActionEvent event) throws UnknownHostException {
        DataAccess dataAccess = new MongoDBAccess(collectCollection.main(), userCollection.getUsername());
        dataAccess.resetTask();
        for (int i = 0 ; i < todoTable.getItems().size() ; i++) {
            TaskFactory task = new CommonTaskFactory();
            AddTaskItemInputBoundary inputBoundary = new AddTask(dataAccess, task);
            TaskRequestModel requestModel = new TaskRequestModel(
                    todoTable.getItems().get(i).getDescription(),
                    todoTable.getItems().get(i).getDate(),
                    todoTable.getItems().get(i).getCategory());
            inputBoundary.create(requestModel);
        }
        errorMessage.setText("ALL TASKS SAVED");
        FadeTransition ft = new FadeTransition(Duration.millis(1850), errorMessage);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setAutoReverse(true);
        ft.play();
    }

    public void presentTask() throws UnknownHostException {
        ArrayList<ArrayList<Object>> allTasks = new ToDoListController().getAllTasks();
        for (ArrayList<Object> allTask : allTasks) {
            todoTable.getItems().add(new CommonTask(allTask.get(0).toString(),
                    allTask.get(1).toString(),
                    allTask.get(2).toString()));
        }
    }

    public void todoDeleteButton(ActionEvent actionEvent) {
        CommonTask selectedItem = (CommonTask) todoTable.getSelectionModel().getSelectedItem();
        todoTable.getItems().remove(selectedItem);
    }


}