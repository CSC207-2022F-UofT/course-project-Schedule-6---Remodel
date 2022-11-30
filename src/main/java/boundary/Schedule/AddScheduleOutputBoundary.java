package boundary.Schedule;

import responseModel.Schedule.ScheduleItemResponseModel;

public interface AddScheduleOutputBoundary {
    ScheduleItemResponseModel prepareSuccessView(ScheduleItemResponseModel scheduleItemResponseModel);

    ScheduleItemResponseModel prepareFailView(String error);
}
