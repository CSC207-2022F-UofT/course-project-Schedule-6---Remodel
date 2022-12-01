package boundary.Task;

import requestModel.TaskRequestModel;
import responseModel.Task.TaskResponseModel;

public interface AddTaskItemInputBoundary {
    TaskResponseModel create(TaskRequestModel inputData);
}
