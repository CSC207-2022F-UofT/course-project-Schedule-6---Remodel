package boundary.Import;

import responseModel.Import.ImportResponseModel;

public interface ImportOutputBoundary {
    ImportResponseModel successfulImport(ImportResponseModel calendar);
}
