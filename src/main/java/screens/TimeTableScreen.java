package screens;

import com.calendarfx.view.CalendarView;
import controller.Schedule.TimetableController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import useCaseInteractor.User.userCollection;

public class TimeTableScreen {
    @FXML
    private Label TimetableUserName;
    @FXML
    private GridPane Gridlock;
    @FXML
    private Button saveButton;
    @FXML
    private Button newEvent;
    public static Label usernameChangeLabel;

    private TimetableController TTC = new TimetableController();

    public void printCalendarEntries(ActionEvent event) {TTC.printCalendarEntries(event);}
    public void scheduleInputsButton(ActionEvent event) {TTC.scheduleInputsButton(event);}

    public void initialize(){
        TTC.loadCalendar(Gridlock);
        usernameChangeLabel = TimetableUserName;
        TTC.setUsernameChangeLabel(userCollection.getUsername());
    }
}

