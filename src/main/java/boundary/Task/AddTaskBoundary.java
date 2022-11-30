package boundary.Task;

import requestModel.TaskRequestModel;
import responseModel.Task.TaskResponseModel;

public interface AddTaskBoundary {
   default TaskResponseModel create(TaskRequestModel input) {
        return null;
    }
}
