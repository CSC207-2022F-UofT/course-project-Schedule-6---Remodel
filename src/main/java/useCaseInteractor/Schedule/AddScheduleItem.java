package useCaseInteractor.Schedule;

import boundary.AddScheduleItemInputBoundary;
import entity.ScheduleItem;
import entity.ScheduleItemFactory;
import presenter.WeeklyInfoPresenter;
import requestModel.ScheduleItemRequestModel;
import responseModel.ScheduleItemResponseModel;

public class AddScheduleItem implements AddScheduleItemInputBoundary {

    final ScheduleItemFactory scheduleItemFactory;

    final WeeklyInfoPresenter schedulePresenter;

    // need to add CommonUser variable so it knows where to add the ScheduleItem


    public AddScheduleItem(ScheduleItemFactory scheduleItemFactory, WeeklyInfoPresenter presenter) {
        this.scheduleItemFactory = scheduleItemFactory;
        this.schedulePresenter = presenter;
    }

    @Override
    public ScheduleItemResponseModel create(ScheduleItemRequestModel inputData) {
        ScheduleItem scheduleItem = scheduleItemFactory.create(inputData.getTitle(),
                inputData.getDate(), inputData.getStartTime(), inputData.getEndTime());
        // created a CommonScheduleItem but need to store it in User
        return null;
//        return schedulePresenter.prepareSuccessView();
    }
}