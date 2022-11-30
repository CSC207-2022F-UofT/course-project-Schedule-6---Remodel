package screens;

import com.calendarfx.view.CalendarView;
import controller.Schedule.TimetableController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class TimeTableScreen {
    @FXML
    private Label TimetableUserName;
    @FXML
    private GridPane Gridlock;
    @FXML
    private Button saveButton;
    @FXML
    private Button newEvent;
    @FXML
    private Label allEntriesSavedLabel;
    public static Label usernameChangeLabel;

    private TimetableController TTC = new TimetableController();

    public void printCalendarEntries(ActionEvent event) throws InterruptedException
    {TTC.printCalendarEntries(event, allEntriesSavedLabel);}
    public void scheduleInputsButton(ActionEvent event) {TTC.scheduleInputsButton(event);}

    public void initialize(){
        TTC.loadCalendar(Gridlock);
        usernameChangeLabel = TimetableUserName;
    }
}

