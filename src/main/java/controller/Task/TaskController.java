package controller.Task;

import boundary.Task.LoadTaskInputBoundary;
import boundary.Task.UpdateTaskItemInputBoundary;
import controller.User.userCollection;
import database.MongoDBAccess;
import entity.Task.CommonTaskFactory;
import entity.Task.TaskFactory;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import main.collectCollection;
import presenter.TaskPresenter;
import requestModel.TaskRequestModel;
import useCaseInteractor.DataAccess;
import useCaseInteractor.Task.LoadTasksUseCase;
import useCaseInteractor.Task.UpdateTask;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public class TaskController {
    private final TaskPresenter taskPresenter = new TaskPresenter();

    public void addNewEntry(TableView<Map> todoTable, TextField newTaskDescription,
                            TextField newTaskDate, TextField newTaskCategory, Label errorMessage) {

        if (newTaskDescription.getText().isBlank() || newTaskCategory.getText().isBlank() || newTaskDate.getText().isBlank()) {
            taskPresenter.setError(errorMessage);
        } else {
            if (checkFormat(newTaskDate.getText())) {
                Map<String, Object> item = new HashMap<>();
                item.put("Description", newTaskDescription.getText());
                item.put("Date", newTaskDate.getText());
                item.put("Category", newTaskCategory.getText());
                todoTable.getItems().add(item);
                taskPresenter.setText(newTaskDescription, newTaskDate, newTaskCategory);
            } else {
                taskPresenter.setDateError(errorMessage);
            }
        }
    }

    public boolean checkFormat(String text) {
        String[] lst = text.split("-");
        return text.matches("\\d{4}-\\d{2}-\\d{2}") &&
                ((Integer.parseInt(lst[0]) > 0) && Integer.parseInt(lst[0]) <= 9999) &&
                ((Integer.parseInt(lst[1]) > 0) && Integer.parseInt(lst[1]) <= 12) &&
                ((Integer.parseInt(lst[2]) > 0) && Integer.parseInt(lst[2]) <= 31);
    }

    public void saveTaskEntries(TableView<Map> todoTable, Label errorMessage) throws UnknownHostException {
        DataAccess dataAccess = new MongoDBAccess(collectCollection.main(), userCollection.getUsername());
        dataAccess.resetTask(); // should not be here

        for (int i = 0; i < todoTable.getItems().size(); i++) {
            TaskFactory task = new CommonTaskFactory();
            UpdateTaskItemInputBoundary inputBoundary = new UpdateTask(dataAccess, task);
            TaskRequestModel requestModel = new TaskRequestModel(
                    todoTable.getItems().get(i).get("Description").toString(),
                    todoTable.getItems().get(i).get("Date").toString(),
                    todoTable.getItems().get(i).get("Category").toString());
            inputBoundary.create(requestModel);
        }
        taskPresenter.saveTasksMessage(errorMessage);
    }

    public void loadTasks(TableView<Map> todoTable) throws UnknownHostException {
        DataAccess dataAccess = new MongoDBAccess(collectCollection.main(), userCollection.getUsername()); // should not be here

        LoadTaskInputBoundary task = new LoadTasksUseCase(dataAccess, taskPresenter, todoTable);
        task.loadTasks();
    }
}
