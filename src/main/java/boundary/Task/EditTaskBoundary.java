package boundary.Task;

import requestModel.ScheduleItemRequestModel;
import requestModel.TaskRequestModel;
import responseModel.Task.TaskResponseModel;

public interface EditTaskBoundary {
    TaskResponseModel edit(TaskRequestModel newInputData, TaskRequestModel oldInputData);
}
