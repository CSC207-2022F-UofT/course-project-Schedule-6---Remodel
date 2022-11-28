package presenter;

import responseModel.Schedule.ScheduleItemResponseModel;

public interface AddSchedulePresenter {
    ScheduleItemResponseModel prepareSuccessView(ScheduleItemResponseModel scheduleItemResponseModel);

    ScheduleItemResponseModel prepareFailView(String error);
}
