package controller;

import boundary.ImportInputBoundary;
import useCaseInteractor.Import.IcsParser;
import requestModel.ImportRequestModel;
import responseModel.ImportResponseModel;

import java.io.FileInputStream;

public class ImportController {
    final ImportInputBoundary input;

    public ImportController(ImportInputBoundary gateway) {
        this.input = gateway;
    }

    ImportResponseModel create(FileInputStream in) {
        ImportRequestModel requestModel = new ImportRequestModel(new IcsParser(in));

        return input.create(requestModel);
    }
}
