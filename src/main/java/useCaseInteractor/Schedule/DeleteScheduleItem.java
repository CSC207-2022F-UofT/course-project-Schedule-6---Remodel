package useCaseInteractor.Schedule;

import boundary.DeleteScheduleItemInputBoundary;
import entity.ScheduleItem;
import entity.ScheduleItemFactory;
import presenter.AddSchedulePresenter;
import presenter.WeekViewPresenter;
import requestModel.ScheduleItemRequestModel;
import responseModel.ScheduleItemResponseModel;
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

        dataAccess.deleteScheduleItem(inputData);

        // not sure about response model yet depends on UI
        ScheduleItemResponseModel responseModel = new ScheduleItemResponseModel(inputData.getTitle(),
                inputData.getDate(), inputData.getStartTime(), inputData.getEndTime());
        return schedulePresenter.prepareSuccessView(responseModel);
    }
}
