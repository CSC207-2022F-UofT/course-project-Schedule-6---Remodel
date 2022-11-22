package boundary;

import requestModel.ImportRequestModel;
import responseModel.ImportResponseModel;

public interface ImportInputBoundary {
    ImportResponseModel create(ImportRequestModel requestModel);

}
