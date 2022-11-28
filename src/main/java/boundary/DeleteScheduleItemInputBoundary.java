package boundary;

import responseModel.ScheduleItemResponseModel;

public interface DeleteScheduleItemInputBoundary {
    ScheduleItemResponseModel delete(ScheduleItemRequestModel inputData);
}
