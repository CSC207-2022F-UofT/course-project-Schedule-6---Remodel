package controller.Task;

import boundary.Task.AddTaskItemInputBoundary;
import presenter.AddTaskPresenter;
import requestModel.TaskRequestModel;
import responseModel.Task.TaskResponseModel;

import java.time.LocalDate;

public class TaskCreationController<String> {

    final AddTaskItemInputBoundary addTaskItemInputBoundary;

    final AddTaskPresenter presenter;

    public TaskCreationController(AddTaskItemInputBoundary inputBoundary, AddTaskPresenter presenter){
        this.addTaskItemInputBoundary = inputBoundary;
        this.presenter = presenter;
    }

    public TaskResponseModel create(java.lang.String title, LocalDate date, String category){
        if (title.isBlank() || (date == null) || (category == null)){
            return presenter.prepareFailView("Please Fill in All Fields");
        }
        TaskRequestModel newInputData = new TaskRequestModel(title, date, (java.lang.String) category);
        return addTaskItemInputBoundary.create(newInputData);
    }

}
