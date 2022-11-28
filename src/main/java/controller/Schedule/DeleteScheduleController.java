package controller.Schedule;

import boundary.Schedule.AddScheduleItemInputBoundary;
import boundary.Schedule.DeleteScheduleItemInputBoundary;
import presenter.AddSchedulePresenter;
import presenter.WeekViewPresenter;
import requestModel.ScheduleItemRequestModel;
import responseModel.Schedule.ScheduleItemResponseModel;

import java.time.LocalDate;
import java.time.LocalTime;

public class DeleteScheduleController {

    final DeleteScheduleItemInputBoundary deleteScheduleItemInputBoundary;

    final WeekViewPresenter presenter;

    public DeleteScheduleController(DeleteScheduleItemInputBoundary inputBoundary, WeekViewPresenter presenter) {
        this.deleteScheduleItemInputBoundary = inputBoundary;
        this.presenter = presenter;
    }

    public ScheduleItemResponseModel delete(String title, LocalDate date, String startTime, String endTime,
                                            String startAMPM, String endAMPM) {
        ScheduleItemRequestModel inputData = new ScheduleItemRequestModel(
                title, date, timeConverter(startTime, startAMPM), timeConverter(endTime, endAMPM));
        return deleteScheduleItemInputBoundary.delete(inputData);
    }

    // might not need this for deleting schedule item
    // changes time from String to LocalTime, and checks if its AM or PM time
    public LocalTime timeConverter(String time, String AMPM) {
        String[] parsedTime = time.split(":");
        if (AMPM.equals("PM")) {
            parsedTime[0] = Integer.toString(Integer.parseInt(parsedTime[0]) + 12);
        }
        return LocalTime.of(Integer.parseInt(parsedTime[0]), Integer.parseInt(parsedTime[1]));
    }
}