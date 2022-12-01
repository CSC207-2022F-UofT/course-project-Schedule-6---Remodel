package boundary.Schedule;

import requestModel.ScheduleItemRequestModel;

public interface AddScheduleItemInputBoundary {
    void create(ScheduleItemRequestModel inputData);
}
