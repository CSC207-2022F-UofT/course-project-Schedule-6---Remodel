package controller.Schedule;

import boundary.AddScheduleItemInputBoundary;
import boundary.EditScheduleItemInputBoundary;
import presenter.AddSchedulePresenter;
import presenter.WeekViewPresenter;
import requestModel.ScheduleItemRequestModel;
import responseModel.ScheduleItemResponseModel;

import java.time.LocalDate;
import java.time.LocalTime;

public class EditScheduleController {

    final EditScheduleItemInputBoundary editScheduleItemInputBoundary;

    final WeekViewPresenter presenter;

    public EditScheduleController(EditScheduleItemInputBoundary inputBoundary, WeekViewPresenter presenter) {
        this.editScheduleItemInputBoundary = inputBoundary;
        this.presenter = presenter;
    }

    public ScheduleItemResponseModel edit(String newTitle, LocalDate newDate, String newStartTime, String newEndTime,
                                            String newStartAMPM, String newEndAMPM,
                                          String oldTitle, LocalDate oldDate, String oldStartTime, String oldEndTime,
                                          String oldStartAMPM, String oldEndAMPM) {
        if (newTitle.isBlank() || (newDate == null) || newStartTime.isBlank() || newEndTime.isBlank()) {
            return presenter.prepareFailView("Please Fill in All Fields");
        } else if (!this.inputTimeChecker(newStartTime, newEndTime)) {
            return presenter.prepareFailView("Please Insert a Valid Time as HH:MM");
        }
        ScheduleItemRequestModel newInputData = new ScheduleItemRequestModel(
                newTitle, newDate, timeConverter(newStartTime, newStartAMPM), timeConverter(newEndTime, newEndAMPM));
        ScheduleItemRequestModel oldInputData = new ScheduleItemRequestModel(
                oldTitle, oldDate, timeConverter(oldStartTime, oldStartAMPM), timeConverter(oldEndTime, oldEndAMPM));
        return editScheduleItemInputBoundary.edit(newInputData, oldInputData);
    }

    // Checks if user inputs startTime and endTime is valid
    public boolean inputTimeChecker(String startTime, String endTime) {
        String[] time = (startTime + ":" + endTime).split(":");
        //if startTime = "12:30" and endTime is "2:15", then time = ["12", "30", "2", "15"]
        return (startTime.matches("\\d{2}:\\d{2}") || startTime.matches("\\d:\\d{2}")) &&
                (endTime.matches("\\d{2}:\\d{2}") || endTime.matches("\\d:\\d{2}")) &&
                (Integer.parseInt(time[0]) <= 12) && (Integer.parseInt(time[0]) > 0) &&
                (Integer.parseInt(time[2]) <= 12) && (Integer.parseInt(time[2]) > 0) &&
                (Integer.parseInt(time[1]) <= 59) && (Integer.parseInt(time[3]) <= 59);
    }

    // changes time from String to LocalTime, and checks if its AM or PM time
    public LocalTime timeConverter(String time, String AMPM) {
        String[] parsedTime = time.split(":");
        if (AMPM.equals("PM")) {
            parsedTime[0] = Integer.toString(Integer.parseInt(parsedTime[0]) + 12);
        }
        return LocalTime.of(Integer.parseInt(parsedTime[0]), Integer.parseInt(parsedTime[1]));
    }
}
