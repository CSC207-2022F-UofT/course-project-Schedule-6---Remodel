package controller.Import;

import boundary.Import.ImportInputBoundary;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import net.fortuna.ical4j.data.ParserException;
import presenter.ImportPresenter;
import useCaseInteractor.Import.IcsParser;
import requestModel.ImportRequestModel;
import responseModel.Import.ImportResponseModel;

import java.io.*;

public class ImportController {
    final ImportInputBoundary input;
    final ImportPresenter presenter;

    public ImportController(ImportInputBoundary gateway, ImportPresenter presenter) {
        this.input = gateway;
        this.presenter = presenter;
    }

    ImportResponseModel create(FileInputStream in) {
        try {
            IcsParser icsParser = new IcsParser(in);
            ImportRequestModel requestModel = new ImportRequestModel(icsParser);
            return this.input.create(requestModel);
        } catch (IOException | ParserException ex) {
            return presenter.failedImport("File format is invalid");
            /* Area for improvement: having the useCase interactor to reflect a failure in import to presenter
            through outputBoundary would better adhere to the clean architecture*/
        }
    }

    public void addNewFile(ActionEvent event, Button fileImportButton, Stage stage){

        FileChooser file_chooser = new FileChooser();
        file_chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.ics"));
        EventHandler<ActionEvent> e = new EventHandler<>() {
            public void handle(ActionEvent e) {
                // get the file selected
                File file = file_chooser.showOpenDialog(stage);
                try {
                    FileInputStream inputStream = new FileInputStream(file);
                    // calls the create method to create a new request
                    create(inputStream);
                } catch (FileNotFoundException ex) {
                    System.out.println("File is invalid");
                }
            }
        };
        fileImportButton.setOnAction(e);
    }
}
