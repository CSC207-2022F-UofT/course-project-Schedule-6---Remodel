package boundary.Task;

import requestModel.ScheduleItemRequestModel;
import requestModel.TaskRequestModel;
import responseModel.Task.TaskResponseModel;

public interface EditTaskInputBoundary {
    TaskResponseModel edit(TaskRequestModel newInputData, TaskRequestModel oldInputData);
}
