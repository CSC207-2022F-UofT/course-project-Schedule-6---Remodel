package controller.Import;

import boundary.Import.ImportInputBoundary;
import net.fortuna.ical4j.data.ParserException;
import presenter.ImportPresenter;
import useCaseInteractor.Import.IcsParser;
import requestModel.ImportRequestModel;
import responseModel.Import.ImportResponseModel;

import java.io.FileInputStream;
import java.io.IOException;

public class ImportController {
    final ImportInputBoundary input;
    final ImportPresenter presenter;

    public ImportController(ImportInputBoundary gateway, ImportPresenter presenter) {
        this.input = gateway;
        this.presenter = presenter;
    }

    ImportResponseModel create(FileInputStream in) {
        try {
            IcsParser input = new IcsParser(in);
            ImportRequestModel requestModel = new ImportRequestModel(input);
            return this.input.create(requestModel);
        } catch (IOException | ParserException e) {
            return presenter.failedImport("File format is invalid");
            /* Area for improvement: having the useCase interactor to reflect a failure in import to presenter
            through outputBoundary would better adhere to the clean architecture*/
        }
    }
}
