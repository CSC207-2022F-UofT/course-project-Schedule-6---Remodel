package controller;

// Temporarily using "pretend inputs" as variables for implementing feature 2

import boundary.AddScheduleItemInputBoundary;
import requestModel.ScheduleItemRequestModel;
import responseModel.ScheduleItemResponseModel;

import java.time.LocalDate;
import java.time.LocalTime;

public class ScheduleController {
    final AddScheduleItemInputBoundary userInput;

    public ScheduleController(AddScheduleItemInputBoundary input) {
        this.userInput = input;
    }

    ScheduleItemResponseModel create(String title, LocalDate date, LocalTime startTime, LocalTime endTime) {
        ScheduleItemRequestModel inputData = new ScheduleItemRequestModel(title, date, startTime, endTime);
        return userInput.create(inputData);
    }

//    ScheduleItemResponseModel delete(String title, LocalDate date, LocalTime startTime, LocalTime endTime) {
//
//    }
//
//    ScheduleItemResponseModel edit(String title, LocalDate date, LocalTime startTime, LocalTime endTime) {
//
//    }
}