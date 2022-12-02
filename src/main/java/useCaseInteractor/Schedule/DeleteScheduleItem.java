package useCaseInteractor.Schedule;

import boundary.Schedule.DeleteScheduleItemInputBoundary;
import presenter.WeekViewPresenter;
import requestModel.ScheduleItemRequestModel;
import responseModel.Schedule.ScheduleItemResponseModel;
import useCaseInteractor.DataAccess;

public class DeleteScheduleItem implements DeleteScheduleItemInputBoundary {

    final DataAccess dataAccess;
    final WeekViewPresenter schedulePresenter;

    // need to add CommonUser variable so it knows where to add the ScheduleItem


    public DeleteScheduleItem(DataAccess dataAccess, WeekViewPresenter presenter) {
        this.dataAccess = dataAccess;
        this.schedulePresenter = presenter;
    }

    @Override
    public ScheduleItemResponseModel delete(ScheduleItemRequestModel inputData) {

        // not sure about response model yet depends on UI
        ScheduleItemResponseModel responseModel = new ScheduleItemResponseModel(inputData.getTitle(),
                inputData.getStartDate(), inputData.getEndDate(), inputData.getStartTime(), inputData.getEndTime());

        dataAccess.deleteScheduleItem(responseModel);

        return schedulePresenter.prepareSuccessView(responseModel);
    }
}
