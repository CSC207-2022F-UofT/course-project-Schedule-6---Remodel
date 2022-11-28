package useCaseInteractor.Schedule;

import boundary.AddScheduleItemInputBoundary;
import entity.ScheduleItem;
import entity.ScheduleItemFactory;
import presenter.AddSchedulePresenter;
import responseModel.ScheduleItemResponseModel;
import useCaseInteractor.DataAccess;

public class AddScheduleItem implements AddScheduleItemInputBoundary {

    final DataAccess dataAccess;
    final ScheduleItemFactory scheduleItemFactory;

    final AddSchedulePresenter schedulePresenter;

    // need to add CommonUser variable so it knows where to add the ScheduleItem


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

        // needs to store it in MongoDB
        // needs to store to a specific user
        ScheduleItemRequestModel newData = new ScheduleItemRequestModel(scheduleItem.getTitle(),
                scheduleItem.getDate(), scheduleItem.getStartTime(), scheduleItem.getEndTime());
        dataAccess.savetoDB(newData);

        // presents the week view
        ScheduleItemResponseModel responseModel = new ScheduleItemResponseModel(scheduleItem.getTitle(),
                scheduleItem.getDate(), scheduleItem.getStartTime(), scheduleItem.getEndTime());
        return schedulePresenter.prepareSuccessView(responseModel);
    }
}