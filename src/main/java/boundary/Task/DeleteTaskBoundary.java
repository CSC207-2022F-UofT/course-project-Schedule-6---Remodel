package boundary.Task;

import requestModel.TaskRequestModel;
import responseModel.Task.TaskResponseModel;

public interface DeleteTaskBoundary {
    TaskResponseModel delete(TaskRequestModel inputData);
}
