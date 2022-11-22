package controller;

// Temporarily using "pretend inputs" as variables for implementing feature 2

import boundary.AddScheduleItemInputBoundary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import requestModel.ScheduleItemRequestModel;
import responseModel.ScheduleItemResponseModel;

import java.time.LocalDate;
import java.time.LocalTime;

public class AddScheduleController {
    final AddScheduleItemInputBoundary userInput;

    @FXML
    private Button addScheduleButton;

    @FXML
    private TextField scheduleTitle;

    @FXML
    private DatePicker scheduleDate;

    @FXML
    private TextField startTime;

    @FXML
    private TextField endTime;

    @FXML
    private ChoiceBox<String> startAMPM;

    @FXML
    private ChoiceBox<String> endAMPM;

    @FXML
    private Label errorMessage;

    private String inputTitle;

    private LocalDate inputDate;

    private LocalTime inputStartTime;

    private LocalTime inputEndTime;

    public AddScheduleController(AddScheduleItemInputBoundary input) {
        this.userInput = input;

        this.inputTitle = scheduleTitle.getText();
        this.inputDate = scheduleDate.getValue();
        this.setTimes();
    }

    public void setTimes() {
        String[] parseStartTime = this.startTime.getText().split(";");
        if (this.startAMPM.getValue().equals("PM")) {
            parseStartTime[0] = Integer.toString(Integer.parseInt(parseStartTime[0]) + 12);
        }
        this.inputStartTime = LocalTime.of(Integer.parseInt(parseStartTime[0]), Integer.parseInt(parseStartTime[1]));

        String[] parseEndTime = this.endTime.getText().split(";");
        if (this.endAMPM.getValue().equals("PM")) {
            parseStartTime[0] = Integer.toString(Integer.parseInt(parseEndTime[0]) + 12);
        }
        this.inputEndTime = LocalTime.of(Integer.parseInt(parseEndTime[0]), Integer.parseInt(parseEndTime[1]));
    }

    public void addScheduleAction(ActionEvent event) {
        errorMessage.setText("");
        if (scheduleTitle.getText().isBlank() || scheduleDate.getEditor().getText().isBlank() ||
                startTime.getText().isBlank() || endTime.getText().isBlank()) {
            errorMessage.setText("Please Fill in All Fields");
        } else if (!inputTimeChecker()) {
            errorMessage.setText("Please Format Time as HH:MM");
        } else {
            create(this.inputTitle, this.inputDate, this.inputStartTime, this.inputEndTime);
        }
    }

    public boolean inputTimeChecker() {
        String[] time = (this.startTime.getText() + this.endTime.getText()).split(";");
        if (this.startTime.getText().matches("\\d{2}:\\d{2}") &&
                this.startTime.getText().matches("\\d{2}:\\d{2}") &&
                (Integer.parseInt(time[0]) <= 12) && (Integer.parseInt(time[2]) <= 12) &&
                (Integer.parseInt(time[1]) <= 59) && (Integer.parseInt(time[3]) <= 59)) {
            return true;
        }
        return false;
    }

    public ScheduleItemResponseModel create(String title, LocalDate date, LocalTime startTime, LocalTime endTime) {
        ScheduleItemRequestModel inputData = new ScheduleItemRequestModel(title, date, startTime, endTime);
        return userInput.create(inputData);
    }
}