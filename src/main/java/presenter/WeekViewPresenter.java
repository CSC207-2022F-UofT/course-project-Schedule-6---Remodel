package presenter;

import responseModel.ScheduleItemResponseModel;

public interface WeekViewPresenter {
    ScheduleItemResponseModel prepareSuccessView(ScheduleItemResponseModel scheduleItemResponseModel);

    ScheduleItemResponseModel prepareFailView(String error);
}
