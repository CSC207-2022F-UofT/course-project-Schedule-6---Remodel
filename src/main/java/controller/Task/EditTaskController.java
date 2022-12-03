package controller.Task;

import boundary.Task.EditTaskInputBoundary;
import presenter.TaskPresenter;
import requestModel.TaskRequestModel;
import responseModel.Task.TaskResponseModel;

import java.time.LocalDate;

public class EditTaskController {
    final EditTaskInputBoundary editTaskInputBoundary;

    final TaskPresenter taskPresenter;

    public EditTaskController(EditTaskInputBoundary editTaskInputBoundary, TaskPresenter taskPresenter) {
        this.editTaskInputBoundary = editTaskInputBoundary;
        this.taskPresenter = taskPresenter;
    }

    public TaskResponseModel edit(String newDescription, LocalDate newDate, boolean newPrivacySetting,
                                  String newCategory,
                                  String oldDescription, LocalDate oldDate, boolean oldPrivacySetting,
                                  String oldCategory) {
        if ((newDescription.isBlank()) || (newDate == null) || (newCategory.isBlank())) {
            return taskPresenter.prepareFailView("Please fill in all fields");
        }
        //[Todo] case where task with oldDescription, oldDate does not exist
        //[Todo] case where task with newDescription, newDate already exists
        else {
            TaskRequestModel newInputData = new TaskRequestModel(newDescription, newDate,
                    newPrivacySetting, newCategory);
            TaskRequestModel oldInputData = new TaskRequestModel(oldDescription, oldDate,
                    oldPrivacySetting, oldCategory);
            return editTaskInputBoundary.edit(newInputData, oldInputData);
        }
    }
}
