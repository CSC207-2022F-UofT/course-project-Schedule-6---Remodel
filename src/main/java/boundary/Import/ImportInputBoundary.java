package boundary.Import;

import requestModel.ImportRequestModel;

/**
 * Interface for ImportInteractor use case
 * Allows the controller (ImportController) to call the use case (ImportInteractor)
 */
public interface ImportInputBoundary {
    void create(ImportRequestModel requestModel);

}
