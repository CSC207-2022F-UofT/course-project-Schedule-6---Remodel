package presenter;

import responseModel.Schedule.ScheduleItemResponseModel;

public interface WeekViewPresenter {
    ScheduleItemResponseModel prepareSuccessView(ScheduleItemResponseModel scheduleItemResponseModel);

    ScheduleItemResponseModel prepareFailView(String error);
}
