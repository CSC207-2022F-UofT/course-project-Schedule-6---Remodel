package controller.Import;

import boundary.Import.ImportInputBoundary;
import controller.User.userCollection;
import database.MongoDBAccess;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import main.collectCollection;
import net.fortuna.ical4j.data.ParserException;
import presenter.ImportPresenter;
import useCaseInteractor.DataAccess;
import useCaseInteractor.Import.IcsParser;
import requestModel.ImportRequestModel;
import responseModel.Import.ImportResponseModel;
import useCaseInteractor.Import.ImportUseCase;

import java.io.*;
import java.net.UnknownHostException;

/**
 * The controller for importing ics files. Users can interact with TimetableScreen to select an input file.
 */
public class ImportController {
    final ImportPresenter PRESENTER;

    /**
     * The constructor of ImportController
     * @param presenter the presenter that this controller interacts with
     */
    public ImportController(ImportPresenter presenter) {
        this.PRESENTER = presenter;
    }

    /**
     * This method creates an ImportRequest when the user opens an ics file in the file selection window.
     * Calls the useCase to create new eventItems or the presenter to prepare the failed view if there's an error.
     * @param in the file path of selected file
     * @param errorMessage the label that prepares an error message
     * @return a response model for creating EventItems or a response model to reflect the failure of doing so.
     */
    ImportResponseModel create(FileInputStream in, Label errorMessage) {
        try {
            IcsParser icsParser = new IcsParser(in);
            ImportRequestModel requestModel = new ImportRequestModel(icsParser);
            ImportInputBoundary input = new ImportUseCase(createDataAccess());
            return input.create(requestModel);
        } catch (IOException | ParserException ex) {
            return PRESENTER.failedImport(errorMessage, "File format is invalid");
            /* Area for improvement: having the useCase to reflect a failure in import to presenter
            through outputBoundary would better adhere to the clean architecture*/
        }
    }

    private DataAccess createDataAccess(){
        try {
            return new MongoDBAccess(collectCollection.main(), userCollection.getUsername());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method opens a file selection window for the user to choose an ics file to import onto the timetable.
     * @param event the action when the user clicks on the import button
     * @param fileImportButton the import button on the UI
     * @param stage the window for file selection
     * @param errorMessage the label that displays an error message to the user if an Exception has occurred
     */
    public void addNewFile(ActionEvent event, Button fileImportButton, Stage stage, Label errorMessage){

        FileChooser file_chooser = new FileChooser();
        file_chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.ics"));
        EventHandler<ActionEvent> e = new EventHandler<>() {
            public void handle(ActionEvent e) {
                // get the file selected
                File file = file_chooser.showOpenDialog(stage);
                try {
                    FileInputStream inputStream = new FileInputStream(file);
                    // calls the create method to create a new import request
                    create(inputStream, errorMessage);
                } catch (FileNotFoundException ex) {
                    errorMessage.setText("File is invalid");
                }
            }
        };
        fileImportButton.setOnAction(e);
    }
}
