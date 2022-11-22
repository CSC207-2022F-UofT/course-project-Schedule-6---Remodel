package boundary;

import requestModel.ScheduleItemRequestModel;
import responseModel.ScheduleItemResponseModel;

public interface AddScheduleItemInputBoundary {
    ScheduleItemResponseModel create(ScheduleItemRequestModel inputData);
}
