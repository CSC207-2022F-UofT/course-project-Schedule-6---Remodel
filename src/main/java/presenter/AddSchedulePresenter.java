package presenter;

import responseModel.ScheduleItemResponseModel;

public interface AddSchedulePresenter {
    ScheduleItemResponseModel prepareSuccessView(ScheduleItemResponseModel scheduleItemResponseModel);

    ScheduleItemResponseModel prepareFailView(String error);
}
