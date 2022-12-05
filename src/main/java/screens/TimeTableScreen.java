

package screens;

import boundary.Import.ImportInputBoundary;
import controller.Import.ImportController;
import controller.Schedule.TimetableController;
import database.MongoDBAccess;
import entity.Schedule.CommonScheduleItemFactory;
import entity.Schedule.ScheduleItemFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;
import main.collectCollection;
import presenter.ImportPresenter;
import useCaseInteractor.DataAccess;
import useCaseInteractor.Import.ImportInteractor;
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

    private final ImportPresenter presenter = new ImportPresenter();

    private final ScheduleItemFactory factory = new CommonScheduleItemFactory();

    private final DataAccess dataAccess;
    {
        try {
            dataAccess = new MongoDBAccess(collectCollection.main(), userCollection.getUsername());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    private final ImportInputBoundary importInputBoundary= new ImportInteractor(presenter, factory, dataAccess);

    private final ImportController importControl = new ImportController(importInputBoundary, presenter);

    // private TimetableController timetableController;
    // private ImportController importControl;

    /*
    public TimeTableScreen(TimetableController controller1, ImportController controller2){
        this.timetableController = controller1;
        this.importControl = controller2;
    }
     */

    public void printCalendarEntries(ActionEvent event) throws UnknownHostException {TTC.printCalendarEntries(event, allEntriesSavedLabel);}

    public void addFutureEntries(ActionEvent event) {TTC.futureEventButton(event);}
    public void addNewFile(ActionEvent event) {importControl.addNewFile(event, fileImportButton, filePicker);}
    public void initialize() throws IOException {
        TTC.loadCalendar(Gridlock);
        usernameChangeLabel = TimetableUserName;
        TTC.setUsernameChangeLabel(userCollection.getUsername());
        TTC.loadTODO(TODO);
    }
}