package boundary;

import useCaseInteractor.ImportResponseModel;

public interface ImportOutputBoundary {
    ImportResponseModel successfulImport(ImportResponseModel calendar);
    // TODO: implement the view of failedImport
}
