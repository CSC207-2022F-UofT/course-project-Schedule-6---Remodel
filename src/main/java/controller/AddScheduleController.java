package controller;

// Temporarily using "pretend inputs" as variables for implementing feature 2

import boundary.AddScheduleItemInputBoundary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.converter.DateTimeStringConverter;
import org.w3c.dom.Text;
import useCaseInteractor.ScheduleItemRequestModel;
import useCaseInteractor.ScheduleItemResponseModel;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AddScheduleController {
    final AddScheduleItemInputBoundary userInput;
    public Button cancelScheduleButton;

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

    private String inputTitle;

    private LocalDate inputDate;

    private LocalTime inputStartTime;

    private LocalTime inputEndTime;

    public AddScheduleController(AddScheduleItemInputBoundary input) {
        this.userInput = input;

        this.inputTitle = scheduleTitle.getText();
        this.inputDate = scheduleDate.getValue();
        this.setTimes(); //Still need to figure out how to go from TextField to LocalTime with "HH:MM;
        //Steven feel free to modify this as you wish. This is just getting the value that is selected
        String sAMPM = startAMPM.getValue();
        String eAMPM = endAMPM.getValue();
    }

    public ScheduleItemResponseModel create(String title, LocalDate date, LocalTime startTime, LocalTime endTime) {
        ScheduleItemRequestModel inputData = new ScheduleItemRequestModel(title, date, startTime, endTime);
        return userInput.create(inputData);
        // Can change into the userinputs now
    }

    public void setTimes() {
    }

    public void cancelScheduleAction(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelScheduleButton.getScene().getWindow();
        stage.close();
    }
}