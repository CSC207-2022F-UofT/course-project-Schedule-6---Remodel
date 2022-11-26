package useCaseInteractor.Schedule;

import boundary.AddScheduleItemInputBoundary;
import entity.ScheduleItem;
import entity.ScheduleItemFactory;
import presenter.AddSchedulePresenter;
import requestModel.ScheduleItemRequestModel;
import responseModel.ScheduleItemResponseModel;
import useCaseInteractor.DataAccess;

public class AddScheduleItem implements AddScheduleItemInputBoundary {

    final DataAccess dataAccess;
    final ScheduleItemFactory scheduleItemFactory;

    final AddSchedulePresenter schedulePresenter;

    public AddScheduleItem(DataAccess dataAccess, ScheduleItemFactory scheduleItemFactory,
                           AddSchedulePresenter presenter) {
        this.dataAccess = dataAccess;
        this.scheduleItemFactory = scheduleItemFactory;
        this.schedulePresenter = presenter;
    }

    @Override
    public ScheduleItemResponseModel create(ScheduleItemRequestModel inputData) {
        ScheduleItem scheduleItem = scheduleItemFactory.create(inputData.getTitle(),
                inputData.getDate(), inputData.getStartTime(), inputData.getEndTime());

        dataAccess.savetoDB(inputData);

        // presents the week view
        ScheduleItemResponseModel responseModel = new ScheduleItemResponseModel(scheduleItem.getTitle(),
                scheduleItem.getDate(), scheduleItem.getStartTime(), scheduleItem.getEndTime());
        return schedulePresenter.prepareSuccessView(responseModel);
    }
}