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

    final AddScheduleOutputBoundary outputBoundary;

    public AddScheduleItem(DataAccess dataAccess, ScheduleItemFactory scheduleItemFactory,
                           AddScheduleOutputBoundary outputBoundary) {
        this.dataAccess = dataAccess;
        this.scheduleItemFactory = scheduleItemFactory;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public ScheduleItemResponseModel create(ScheduleItemRequestModel inputData) {
        ScheduleItem scheduleItem = scheduleItemFactory.create(inputData.getTitle(),
                inputData.getDate(), inputData.getStartTime(), inputData.getEndTime());

        dataAccess.setSchedule(inputData);

        // presents the week view
        ScheduleItemResponseModel responseModel = new ScheduleItemResponseModel(scheduleItem.getTitle(),
                scheduleItem.getDate(), scheduleItem.getStartTime(), scheduleItem.getEndTime());
        return outputBoundary.prepareSuccessView(responseModel);
    }
}