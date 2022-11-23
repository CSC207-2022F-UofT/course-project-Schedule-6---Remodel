package presenter;

import requestModel.ScheduleItemRequestModel;
import responseModel.ScheduleItemResponseModel;

public interface WeeklyInfoPresenter {

    ScheduleItemResponseModel prepareSuccessView(ScheduleItemResponseModel scheduleItemResponseModel);

    ScheduleItemResponseModel prepareFailView(String error);
}
