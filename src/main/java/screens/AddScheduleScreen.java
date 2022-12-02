package screens;

import controller.Schedule.AddScheduleController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AddScheduleScreen {

    @FXML
    private Button addScheduleButton;

    @FXML
    private TextField scheduleTitle;

    @FXML
    private DatePicker startDate;

    @FXML
    private DatePicker endDate;
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

    public void addScheduleAction(ActionEvent event){};
    public void cancelScheduleAction(ActionEvent event){};


//    public AddScheduleScreen(AddScheduleController controller) {
//        this.addScheduleController = controller;
//    }
//
//    public void addScheduleAction(ActionEvent event) {
//        System.out.println("Click" + event.getEventType());
//
//        // add try and catch to catch errorMessage from controller
//        addScheduleController.create(this.scheduleTitle.getText(), this.scheduleDate.getValue(),
//                this.startTime.getText(), this.endTime.getText(), this.startAMPM.getValue(), this.endAMPM.getValue());
//    }
}
