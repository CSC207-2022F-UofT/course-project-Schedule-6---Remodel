package screens;

import controller.Schedule.TimetableController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;
import useCaseInteractor.User.userCollection;


import java.io.IOException;
import java.net.UnknownHostException;

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