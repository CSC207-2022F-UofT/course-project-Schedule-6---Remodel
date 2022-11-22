package boundary;

import requestModel.ScheduleItemRequestModel;
import responseModel.ScheduleItemResponseModel;

public interface DeleteScheduleItemInputBoundary {
    ScheduleItemResponseModel delete(ScheduleItemRequestModel inputData);
}
