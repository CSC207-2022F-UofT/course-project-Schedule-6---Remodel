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
import useCaseInteractor.Import.ImportInteractor;

import java.io.*;
import java.net.UnknownHostException;

public class ImportController {
    final ImportPresenter presenter;

    public ImportController(ImportPresenter presenter) {
        this.presenter = presenter;
    }

    ImportResponseModel create(FileInputStream in, Label errorMessage) {
        try {
            IcsParser icsParser = new IcsParser(in);
            ImportRequestModel requestModel = new ImportRequestModel(icsParser);
            ImportInputBoundary input = new ImportInteractor(creatDataAccess());
            return input.create(requestModel);
        } catch (IOException | ParserException ex) {
            return presenter.failedImport(errorMessage, "File format is invalid");
            /* Area for improvement: having the useCase interactor to reflect a failure in import to presenter
            through outputBoundary would better adhere to the clean architecture*/
        }
    }

    private DataAccess creatDataAccess(){
        try {
            DataAccess dataAccess = new MongoDBAccess(collectCollection.main(), userCollection.getUsername());
            return dataAccess;
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    public void addNewFile(ActionEvent event, Button fileImportButton, Stage stage, Label errorMessage){

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
}
