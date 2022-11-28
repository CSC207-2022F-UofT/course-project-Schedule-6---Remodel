package boundary;

import responseModel.ScheduleItemResponseModel;

public interface AddScheduleItemInputBoundary {
    ScheduleItemResponseModel create(ScheduleItemRequestModel inputData);
}
