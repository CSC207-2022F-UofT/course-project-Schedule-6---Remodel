package boundary;

import responseModel.ImportResponseModel;

public interface ImportOutputBoundary {
    ImportResponseModel successfulImport(ImportResponseModel calendar);
    // TODO: implement the view of failedImport
}
