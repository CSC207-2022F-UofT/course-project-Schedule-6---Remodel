package boundary.Task;

import requestModel.TaskRequestModel;

/**
 * Interface for UpdateTask use case
 * Allows the controller (TaskController) to call the use case (UpdateTask)
 */
public interface UpdateTaskItemInputBoundary {
    void create(TaskRequestModel inputData);
}
