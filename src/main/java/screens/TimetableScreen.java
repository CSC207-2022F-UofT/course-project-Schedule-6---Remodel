

package screens;

import boundary.Import.ImportInputBoundary;
import controller.Import.ImportController;
import controller.Event.TimetableController;
import database.MongoDBAccess;
import entity.Event.CommonEventItemFactory;
import entity.Event.EventItemFactory;
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

public class TimetableScreen {
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
    private final ImportInputBoundary importInputBoundary= new ImportInteractor(presenter, factory, dataAccess);

    private final ImportController importControl = new ImportController(importInputBoundary, presenter);
    public void saveCalenderEntries(ActionEvent event) throws UnknownHostException {
        timetableController.saveCalendarEntries(allEntriesSavedLabel);
    }

    public void addFutureEntries(ActionEvent event) {
        timetableController.futureEventButton(event);
    }
    public void addNewFile(ActionEvent event) {
        importControl.addNewFile(event, fileImportButton, filePicker);
    }
    public void initialize() throws IOException {
        timetableController.loadCalendar(Gridlock);
        usernameChangeLabel = TimetableUserName;
        timetableController.setUsernameChangeLabel(userCollection.getUsername());
        timetableController.loadTODO(TODO);
        timetableController.loginLoadEvents();
    }
}