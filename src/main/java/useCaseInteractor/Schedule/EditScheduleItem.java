package useCaseInteractor.Schedule;

import boundary.Schedule.EditScheduleItemInputBoundary;
import entity.Schedule.ScheduleItem;
import entity.Schedule.ScheduleItemFactory;
import presenter.AddSchedulePresenter;
import presenter.WeekViewPresenter;
import requestModel.ScheduleItemRequestModel;
import responseModel.Schedule.ScheduleItemResponseModel;
import useCaseInteractor.DataAccess;

public class EditScheduleItem implements EditScheduleItemInputBoundary {
    final DataAccess dataAccess;
    final WeekViewPresenter schedulePresenter;

    public EditScheduleItem(DataAccess dataAccess, WeekViewPresenter presenter) {
        this.dataAccess = dataAccess;
        this.schedulePresenter = presenter;
    }

    @Override
    public ScheduleItemResponseModel edit(ScheduleItemRequestModel newInputData,
                                          ScheduleItemRequestModel oldInputData) {

        dataAccess.deleteScheduleItem(oldInputData);
        dataAccess.setSchedule(oldInputData);

        // not sure about response model yet depends on UI
        ScheduleItemResponseModel responseModel = new ScheduleItemResponseModel(newInputData.getTitle(),
                newInputData.getDate(), newInputData.getStartTime(), newInputData.getEndTime());
        return schedulePresenter.prepareSuccessView(responseModel);
    }
}
