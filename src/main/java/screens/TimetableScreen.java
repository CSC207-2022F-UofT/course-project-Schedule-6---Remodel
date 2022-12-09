

package screens;

import controller.Import.ImportController;
import controller.Event.TimetableController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;
import presenter.ImportPresenter;
import controller.User.userCollection;


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

    private final ImportController importControl = new ImportController(presenter);

    public void saveCalenderEntries(ActionEvent event) throws UnknownHostException {
        timetableController.saveCalendarEntries(allEntriesSavedLabel);
    }

    public void addFutureEntries(ActionEvent event) {
        timetableController.futureEventButton(event);
    }

    public void addNewFile(ActionEvent event) {
        importControl.addNewFile(event, fileImportButton, filePicker, allEntriesSavedLabel);
    }
    public void initialize() throws IOException {
        timetableController.loadCalendar(Gridlock);
        usernameChangeLabel = TimetableUserName;
        timetableController.setUsernameChangeLabel(userCollection.getUsername());
        timetableController.loadTODO(TODO);
        timetableController.loginLoadEvents();
    }
}