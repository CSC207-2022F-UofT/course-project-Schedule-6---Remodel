

package screens;

import boundary.Import.ImportInputBoundary;
import controller.Import.ImportController;
import controller.Schedule.ScheduleController;
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

public class ScheduleScreen {
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
    private final ScheduleController scheduleController = new ScheduleController();

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
    public void printCalendarEntries(ActionEvent event) throws UnknownHostException {
        scheduleController.printCalendarEntries(event,
            allEntriesSavedLabel);}

    public void addFutureEntries(ActionEvent event) {
        scheduleController.futureEventButton(event);}
    public void addNewFile(ActionEvent event) {importControl.addNewFile(event, fileImportButton, filePicker);}
    public void initialize() throws IOException {
        scheduleController.loadCalendar(Gridlock);
        usernameChangeLabel = TimetableUserName;
        scheduleController.setUsernameChangeLabel(userCollection.getUsername());
        scheduleController.loadTODO(TODO);
    }
}