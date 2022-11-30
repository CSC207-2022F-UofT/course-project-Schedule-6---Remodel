package presenter;

import boundary.Schedule.AddScheduleOutputBoundary;
import responseModel.Schedule.ScheduleItemResponseModel;

public class AddSchedulePresenter implements AddScheduleOutputBoundary {
    @Override
    public ScheduleItemResponseModel prepareSuccessView(ScheduleItemResponseModel scheduleItemResponseModel) {
        return null;
    }

    @Override
    public ScheduleItemResponseModel prepareFailView(String error) {
        return null;
    }
}
