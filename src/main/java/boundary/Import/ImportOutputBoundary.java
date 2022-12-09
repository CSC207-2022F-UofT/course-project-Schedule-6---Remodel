package boundary.Import;

import responseModel.Import.ImportResponseModel;

/**
 * Interface for ImportPresenter
 * Allows for use case (ImportInteractor) to call the presenter (ImportPresenter)
 */
public interface ImportOutputBoundary {
    ImportResponseModel successfulImport(ImportResponseModel calendar);
}
