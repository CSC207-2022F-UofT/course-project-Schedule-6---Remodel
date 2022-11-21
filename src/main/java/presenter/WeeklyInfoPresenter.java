package presenter;

import useCaseInteractor.ScheduleItemResponseModel;

public interface WeeklyInfoPresenter {

    ScheduleItemResponseModel prepareSuccessView(ScheduleItemResponseModel scheduleItemResponseModel);
}
