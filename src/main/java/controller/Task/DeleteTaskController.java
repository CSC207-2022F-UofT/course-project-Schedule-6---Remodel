package controller.Task;

import boundary.Task.DeleteTaskInputBoundary;
import presenter.TaskPresenter;
import requestModel.TaskRequestModel;
import responseModel.Task.TaskResponseModel;

import java.time.LocalDate;

public class DeleteTaskController {
    final DeleteTaskInputBoundary deleteTaskInputBoundary;

    final TaskPresenter taskPresenter;

    public DeleteTaskController(DeleteTaskInputBoundary deleteTaskInputBoundary, TaskPresenter taskPresenter) {
        this.deleteTaskInputBoundary = deleteTaskInputBoundary;
        this.taskPresenter = taskPresenter;
    }

    public TaskResponseModel delete(String title, LocalDate date, boolean privacySetting, String category) {
        TaskRequestModel inputData = new TaskRequestModel(title, date, privacySetting, category);
        return deleteTaskInputBoundary.delete(inputData);
    }
}
