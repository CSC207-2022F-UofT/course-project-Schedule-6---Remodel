package screens;

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

    public void addScheduleAction(ActionEvent event){}
    public void cancelScheduleAction(ActionEvent event){}





//    private final UpdateScheduleController addScheduleController;

//    public AddScheduleScreen(UpdateScheduleController controller) {
//        this.addScheduleController = controller;
//    }
//
//    public void addScheduleAction(ActionEvent event) {
//        System.out.println("Click" + event.getEventType());
//
//        addScheduleController.create(errorMessage, this.scheduleTitle.getText(),
//                this.startDate.getValue(), this.endDate.getValue(),
//                this.startTime.getText(), this.endTime.getText(), this.startAMPM.getValue(), this.endAMPM.getValue());
//    }
}
