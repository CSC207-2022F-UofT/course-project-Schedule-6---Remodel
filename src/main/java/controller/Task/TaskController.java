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

    /**
     * When user fills in the textfields on the To-Do list screen, and clicks add. This method will
     * check if the inputs are valid, and display the new task onto the todoTable
     *
     * @param todoTable          the table that display the tasks
     * @param newTaskDescription textfield for the description of a new task
     * @param newTaskDate        textfield for the date of a new task
     * @param newTaskCategory    textfield for the category of a new task
     * @param errorMessage       label that displays a message
     */
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


    /**
     * Helper function for addNewEntry.
     * Checks if the user inputted date is valid and follows the format YYYY-MM-DD
     *
     * @param date user inputted date
     * @return returns true if date input is valid
     */
    public boolean checkFormat(String date) {
        String[] lst = date.split("-");
        return date.matches("\\d{4}-\\d{2}-\\d{2}") &&
                ((Integer.parseInt(lst[0]) > 0) && Integer.parseInt(lst[0]) <= 9999) &&
                ((Integer.parseInt(lst[1]) > 0) && Integer.parseInt(lst[1]) <= 12) &&
                ((Integer.parseInt(lst[2]) > 0) && Integer.parseInt(lst[2]) <= 31);
    }

    /**
     * Called when the user clicks the Save button on the To-Do List screen.
     * Grabs all the tasks on the to-do list, and calls the use case to save the tasks onto the database
     *
     * @param todoTable    the table that display the tasks
     * @param errorMessage the table that display the tasks
     */
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

    /**
     * Called when the User clicks the Login button on the LoginScreen.
     * Calls the LoadTasksUseCase to grab the data from the database, go to the presenter, and load the task
     * data onto the To-Do list screen
     *
     * @param todoTable
     * @throws UnknownHostException
     */
    public void loadTasks(TableView<Map> todoTable) throws UnknownHostException {
        DataAccess dataAccess = new MongoDBAccess(collectCollection.main(), userCollection.getUsername()); // should not be here

        LoadTaskInputBoundary task = new LoadTasksUseCase(dataAccess, taskPresenter, todoTable);
        task.loadTasks();
    }
}
