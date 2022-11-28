package boundary;

import responseModel.ScheduleItemResponseModel;

public interface EditScheduleItemInputBoundary {
    ScheduleItemResponseModel edit(ScheduleItemRequestModel inputData);
}
