package controller.Import;

import boundary.Import.ImportInputBoundary;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import net.fortuna.ical4j.data.ParserException;
import presenter.ImportPresenter;
import requestModel.ImportRequestModel;
import useCaseInteractor.Import.IcsParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ImportController {
    final ImportInputBoundary input;
    final ImportPresenter presenter;

    public ImportController(ImportInputBoundary gateway, ImportPresenter presenter) {
        this.input = gateway;
        this.presenter = presenter;
    }

    /**
     * When user clicks Import ICS button, this method will be called
     */
    public void addNewFile(Button fileImportButton, Stage stage, Label errorMessage) {

        FileChooser file_chooser = new FileChooser();
        file_chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.ics"));
        EventHandler<ActionEvent> e = new EventHandler<>() {
            public void handle(ActionEvent e) {
                // get the file selected
                File file = file_chooser.showOpenDialog(stage);
                try {
                    FileInputStream inputStream = new FileInputStream(file);
                    // calls the create method to create a new request
                    create(inputStream, errorMessage);
                } catch (FileNotFoundException ex) {
                    errorMessage.setText("File is invalid");
                }
            }
        };
        fileImportButton.setOnAction(e);
    }

    /**
     * Takes in the ICS file data and calls the ImportInteractor use case
     *
     * @param in           ICS file
     * @param errorMessage label to display a message on the screen
     */
    void create(FileInputStream in, Label errorMessage) {
        try {
            IcsParser icsParser = new IcsParser(in);
            ImportRequestModel requestModel = new ImportRequestModel(icsParser);
            this.input.create(requestModel);
        } catch (IOException | ParserException ex) {
            presenter.failedImport(errorMessage, "File format is invalid");
            /* Area for improvement: having the useCase interactor to reflect a failure in import to presenter
            through outputBoundary would better adhere to the clean architecture*/
        }
    }
}
