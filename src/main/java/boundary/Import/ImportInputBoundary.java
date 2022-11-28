package boundary.Import;

import requestModel.ImportRequestModel;
import responseModel.Import.ImportResponseModel;

public interface ImportInputBoundary {
    ImportResponseModel create(ImportRequestModel requestModel);

}
