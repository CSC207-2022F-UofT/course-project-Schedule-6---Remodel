package useCaseInteractor;

import boundary.AddScheduleItemInputBoundary;
import entity.ScheduleItem;
import entity.ScheduleItemFactory;

public class AddScheduleItem implements AddScheduleItemInputBoundary {

    ScheduleItemFactory scheduleItemFactory;

    // need to add CommonUser variable so it knows where to add the ScheduleItem


    public AddScheduleItem(ScheduleItemFactory scheduleItemFactory) {
        this.scheduleItemFactory = scheduleItemFactory;
    }

    @Override
    public ScheduleItemResponseModel create(ScheduleItemInputData inputData) {
        ScheduleItem scheduleItem = scheduleItemFactory.create(inputData.getTitle(),
                inputData.getDate(), inputData.getStartTime(), inputData.getEndTime());
        // created a CommonScheduleItem but need to store it in CommonUser
        return null;
    }
}