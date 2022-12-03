package useCaseInteractor.Schedule;

import boundary.Schedule.AddScheduleItemInputBoundary;
import entity.Schedule.ScheduleItem;
import entity.Schedule.ScheduleItemFactory;
import boundary.Schedule.AddScheduleOutputBoundary;
import requestModel.ScheduleItemRequestModel;
import responseModel.Schedule.ScheduleItemResponseModel;
import useCaseInteractor.DataAccess;

public class AddScheduleItem implements AddScheduleItemInputBoundary {

    final DataAccess dataAccess;
    final ScheduleItemFactory scheduleItemFactory;


    public AddScheduleItem(DataAccess dataAccess, ScheduleItemFactory scheduleItemFactory) {
        this.dataAccess = dataAccess;
        this.scheduleItemFactory = scheduleItemFactory;
    }

    @Override
    public void create(ScheduleItemRequestModel inputData) {
        ScheduleItem scheduleItem = scheduleItemFactory.create(inputData.getTitle(),
                inputData.getStartDate(), inputData.getEndDate(), inputData.getStartTime(), inputData.getEndTime());

        ScheduleItemResponseModel responseModel = new ScheduleItemResponseModel(scheduleItem.getTitle(),
                scheduleItem.getStartDate(), scheduleItem.getEndDate(),
                scheduleItem.getStartTime(), scheduleItem.getEndTime());

        dataAccess.setSchedule(responseModel);
    }
}