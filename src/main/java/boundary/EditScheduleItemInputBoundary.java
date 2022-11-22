package boundary;

import requestModel.ScheduleItemRequestModel;
import responseModel.ScheduleItemResponseModel;

public interface EditScheduleItemInputBoundary {
    ScheduleItemResponseModel edit(ScheduleItemRequestModel inputData);
}
