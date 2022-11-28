package boundary.Schedule;

import requestModel.ScheduleItemRequestModel;
import responseModel.Schedule.ScheduleItemResponseModel;

public interface EditScheduleItemInputBoundary {
    ScheduleItemResponseModel edit(ScheduleItemRequestModel newInputData, ScheduleItemRequestModel oldInputData);
}
