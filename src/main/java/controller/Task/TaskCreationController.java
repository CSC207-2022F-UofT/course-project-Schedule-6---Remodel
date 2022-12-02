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

    public TaskResponseModel create(java.lang.String descripiton, LocalDate date, Boolean isPrivate, java.lang.String category){
        if (descripiton.isBlank() || (date == null) || (isPrivate == null) || (category == null)){
            return presenter.prepareFailView("Please Fill in All Fields");
        }
        TaskRequestModel newInputData = new TaskRequestModel(descripiton, date, isPrivate, category);
        return addTaskItemInputBoundary.create(newInputData);
    }

}
