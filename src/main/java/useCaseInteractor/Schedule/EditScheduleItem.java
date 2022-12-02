package useCaseInteractor.Schedule;

import boundary.Schedule.EditScheduleItemInputBoundary;
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

        // not sure about response model yet depends on UI
        ScheduleItemResponseModel newresponseModel = new ScheduleItemResponseModel(newInputData.getTitle(),
                newInputData.getStartDate(), newInputData.getEndDate(),
                newInputData.getStartTime(), newInputData.getEndTime());

        ScheduleItemResponseModel oldresponseModel = new ScheduleItemResponseModel(oldInputData.getTitle(),
                oldInputData.getStartDate(), oldInputData.getEndDate(),
                oldInputData.getStartTime(), oldInputData.getEndTime());

        dataAccess.deleteScheduleItem(oldresponseModel);
        dataAccess.setSchedule(newresponseModel);

        return schedulePresenter.prepareSuccessView(newresponseModel);
    }
}
