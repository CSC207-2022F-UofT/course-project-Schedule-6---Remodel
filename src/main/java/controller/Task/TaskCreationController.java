package controller.Task;

import boundary.Task.AddTaskItemInputBoundary;
import presenter.TaskPresenter;
import requestModel.TaskRequestModel;
import responseModel.Task.TaskResponseModel;

import java.time.LocalDate;

public class TaskCreationController<String> {

    final AddTaskItemInputBoundary addTaskItemInputBoundary;

    final TaskPresenter presenter;

    public TaskCreationController(AddTaskItemInputBoundary inputBoundary, TaskPresenter presenter){
        this.addTaskItemInputBoundary = inputBoundary;
        this.presenter = presenter;
    }

    public TaskResponseModel create(java.lang.String description, LocalDate date, Boolean isPrivate, java.lang.String category){
        if (description.isBlank() || (date == null) || (isPrivate == null) || (category == null)){
            return presenter.prepareFailView("Please Fill in All Fields");
        }
        //[Todo] case where Task with the same description, date already exists
        TaskRequestModel newInputData = new TaskRequestModel(description, date, isPrivate, category);
        return addTaskItemInputBoundary.create(newInputData);
    }

}
