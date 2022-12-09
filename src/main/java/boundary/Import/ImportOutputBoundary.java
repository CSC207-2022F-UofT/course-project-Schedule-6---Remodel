package boundary.Import;

import responseModel.Import.ImportResponseModel;

/**
 * An interface for the ImportUseCase to indirectly access the ImportPresenter
 */
public interface ImportOutputBoundary {
    /**
     * @param responseModel keeps track of the attributes of EventItems created
     * @return ImportResponseModel of successful import and EventItem creations
     */
    ImportResponseModel successfulImport(ImportResponseModel responseModel);
}
