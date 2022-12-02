package boundary.Task;

import requestModel.TaskRequestModel;
import responseModel.Task.TaskResponseModel;

public interface DeleteTaskInputBoundary {
    TaskResponseModel delete(TaskRequestModel requestModel);
}
