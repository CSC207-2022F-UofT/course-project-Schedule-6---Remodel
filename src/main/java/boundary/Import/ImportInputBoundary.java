package boundary.Import;

import requestModel.ImportRequestModel;
import responseModel.Import.ImportResponseModel;

/**
 * The interface for controller to access useCase via dependency inversion
 */
public interface ImportInputBoundary {
    /**
     * This method creates new EventItems according to the information passed in through the
     * request model
     * @param requestModel for file import
     * @return ImportResponseModel of successful import and EventItem creations
     */
    ImportResponseModel create(ImportRequestModel requestModel);

}
