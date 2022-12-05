package controller.Task;

import boundary.Task.AddTaskItemInputBoundary;
import javafx.scene.control.Label;
import presenter.TaskCreationPresenter;
import presenter.TaskPresenter;
import requestModel.TaskRequestModel;
import responseModel.Task.TaskResponseModel;

import java.time.LocalDate;

public class TaskCreationController<String> {

    final AddTaskItemInputBoundary addTaskItemInputBoundary;

    final TaskCreationPresenter taskCreationPresenter;

    public TaskCreationController(AddTaskItemInputBoundary inputBoundary, TaskCreationPresenter taskCreationPresenter){
        this.addTaskItemInputBoundary = inputBoundary;
        this.taskCreationPresenter = taskCreationPresenter;
    }

    public void create(Label label,java.lang.String description, java.lang.String date, java.lang.String category){
        if (description.isBlank() || (date == null) || (category == null)){
            taskCreationPresenter.prepareFailView(label,"Please Fill in All Fields");
        }
        //[Todo] case where Task with the same description, date already exists
        TaskRequestModel newInputData = new TaskRequestModel(description, date, category);
        addTaskItemInputBoundary.create(newInputData);
        taskCreationPresenter.prepareSuccessView(label, "Task Added!");
    }
}
