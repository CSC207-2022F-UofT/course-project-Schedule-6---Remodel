package controller;

// Temporarily using "pretend inputs" as variables for implementing feature 2

import boundary.AddScheduleItemInputBoundary;
import requestModel.ScheduleItemRequestModel;
import responseModel.ScheduleItemResponseModel;

import java.time.LocalDate;
import java.time.LocalTime;

public class AddScheduleController {

    final AddScheduleItemInputBoundary userInput;

    public AddScheduleController(AddScheduleItemInputBoundary input) {
        this.userInput = input;
    }

    public ScheduleItemResponseModel create(String title, LocalDate date, String startTime, String endTime,
                                            String startAMPM, String endAMPM) {
        errorMessage.setText("");
        if (title.isBlank() || (date == null) || startTime.isBlank() || endTime.isBlank()) {
            errorMessage.setText("Please Fill in All Fields");
        } else if (!this.inputTimeChecker(startTime, endTime)) {
            errorMessage.setText("Please Insert a Valid Time as HH:MM");
        } else {
            LocalTime fixedStartTime = timeConverter(startTime, startAMPM);
            LocalTime fixedEndTime = timeConverter(endTime, endAMPM);
            ScheduleItemRequestModel inputData = new ScheduleItemRequestModel(
                    title, date, fixedStartTime, fixedEndTime);
            return userInput.create(inputData);
        }
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