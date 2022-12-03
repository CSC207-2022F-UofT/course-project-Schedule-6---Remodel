package screens;

import com.calendarfx.view.CalendarView;
import controller.Schedule.TimetableController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.LoginPage;
import useCaseInteractor.User.userCollection;


import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Objects;

public class TimeTableScreen {
    @FXML
    private Label TimetableUserName;
    @FXML
    private GridPane Gridlock;
    @FXML
    private Button saveButton;
    @FXML
    private Button futureEventButton;
    @FXML
    private Label allEntriesSavedLabel;
    @FXML
    private GridPane TODO;
    @FXML
    private Button fileImportButton;
    public static Label usernameChangeLabel;
    private Stage filePicker = new Stage();

    private TimetableController TTC = new TimetableController();

    public void printCalendarEntries(ActionEvent event) throws InterruptedException, UnknownHostException {TTC.printCalendarEntries(event, allEntriesSavedLabel);}
    public void addFutureEntries(ActionEvent event) {TTC.futureEventButton(event);}
    public void addNewFile(ActionEvent event) {TTC.addNewFile(event, fileImportButton, filePicker);}
    public void initialize() throws IOException {
        TTC.loadCalendar(Gridlock);
        usernameChangeLabel = TimetableUserName;
        TTC.setUsernameChangeLabel(userCollection.getUsername());
        TTC.loadTODO(TODO);
    }
}