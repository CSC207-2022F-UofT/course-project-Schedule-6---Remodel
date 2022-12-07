package screens;

import controller.Event.TimetableController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class FutureEventScreen {

    @FXML
    private TextField eventTitle;

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
    private Button cancelEventButton;
    private final TimetableController timetableController = new TimetableController();

    public void addEventAction(ActionEvent event){
        timetableController.addEventAction(
            event, eventTitle, startDate, endDate, startTime, endTime, errorMessage);}
    public void cancelEventAction(ActionEvent event){
        timetableController.cancelEventAction(event, cancelEventButton);}

}
