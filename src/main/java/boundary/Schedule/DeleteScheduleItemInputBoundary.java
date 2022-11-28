package boundary.Schedule;

import requestModel.ScheduleItemRequestModel;
import responseModel.Schedule.ScheduleItemResponseModel;

public interface DeleteScheduleItemInputBoundary {
    ScheduleItemResponseModel delete(ScheduleItemRequestModel inputData);
}
