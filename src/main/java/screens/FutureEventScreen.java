package screens;

import controller.Schedule.ScheduleController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class FutureEventScreen {

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
    private Label errorMessage;
    @FXML
    private Button cancelScheduleButton;
    private final ScheduleController scheduleController = new ScheduleController();

    public void addScheduleAction(ActionEvent event){
        scheduleController.addScheduleAction(
            event, scheduleTitle, startDate, endDate, startTime, endTime, errorMessage);}
    public void cancelScheduleAction(ActionEvent event){
        scheduleController.cancelScheduleAction(event, cancelScheduleButton);}

}
