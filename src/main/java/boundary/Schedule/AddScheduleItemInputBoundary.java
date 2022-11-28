package boundary.Schedule;

import requestModel.ScheduleItemRequestModel;
import responseModel.Schedule.ScheduleItemResponseModel;

public interface AddScheduleItemInputBoundary {
    ScheduleItemResponseModel create(ScheduleItemRequestModel inputData);
}
