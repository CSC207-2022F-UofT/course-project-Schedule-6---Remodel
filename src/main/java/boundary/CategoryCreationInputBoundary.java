package boundary;

import requestModel.CategoryCreationRequestModel;
import responseModel.CategoryCreationResponseModel;

public interface CategoryCreationInputBoundary {
    CategoryCreationResponseModel create(CategoryCreationRequestModel requestModel);
}
