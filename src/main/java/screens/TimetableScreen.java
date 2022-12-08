package screens;

import boundary.Import.ImportInputBoundary;
import controller.Event.TimetableController;
import controller.Import.ImportController;
import controller.User.userCollection;
import database.MongoDBAccess;
import entity.Event.CommonEventItemFactory;
import entity.Event.EventItemFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.collectCollection;
import presenter.ImportPresenter;
import useCaseInteractor.DataAccess;
import useCaseInteractor.Import.ImportInteractor;

import java.io.IOException;
import java.net.UnknownHostException;

public class TimetableScreen {

    @FXML
    public Button saveButton;
    @FXML
    public Button futureEventButton;
    @FXML
    private Label TimetableUserName;
    @FXML
    private GridPane Gridlock;
    @FXML
    private Label allEntriesSavedLabel;
    @FXML
    private GridPane TODO;
    @FXML
    private Button fileImportButton;
    public static Label usernameChangeLabel;
    private final Stage filePicker = new Stage();
    private final TimetableController timetableController = new TimetableController();

    private final ImportPresenter presenter = new ImportPresenter();

    private final EventItemFactory factory = new CommonEventItemFactory();

    private final DataAccess dataAccess;

    {
        try {
            dataAccess = new MongoDBAccess(collectCollection.main(), userCollection.getUsername());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    private final ImportInputBoundary importInputBoundary = new ImportInteractor(presenter, factory, dataAccess);

    private final ImportController importControl = new ImportController(importInputBoundary, presenter);

    public void saveCalenderEntries() throws UnknownHostException {
        timetableController.saveCalendarEntries(allEntriesSavedLabel);
    }

    public void addFutureEntries() {
        timetableController.futureEventButton();
    }

    public void addNewFile() {
        importControl.addNewFile(fileImportButton, filePicker, allEntriesSavedLabel);
    }

    public void initialize() throws IOException {
        timetableController.loadCalendar(Gridlock);
        usernameChangeLabel = TimetableUserName;
        timetableController.setUsernameChangeLabel(userCollection.getUsername());
        timetableController.loadTODO(TODO);
        timetableController.loginLoadEvents();
    }
}