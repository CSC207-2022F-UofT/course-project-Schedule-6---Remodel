package useCaseInteractor.Schedule;

import boundary.Schedule.UpdateScheduleInputBoundary;
import entity.Schedule.ScheduleItem;
import entity.Schedule.ScheduleItemFactory;
import requestModel.ScheduleItemRequestModel;
import responseModel.Schedule.ScheduleItemResponseModel;
import useCaseInteractor.DataAccess;

public class UpdateScheduleItem implements UpdateScheduleInputBoundary {

    final DataAccess dataAccess;
    final ScheduleItemFactory scheduleItemFactory;

    public UpdateScheduleItem(DataAccess dataAccess, ScheduleItemFactory scheduleItemFactory) {
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