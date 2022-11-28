package boundary.Category;

import requestModel.CategoryCreationRequestModel;
import responseModel.Category.CategoryCreationResponseModel;

public interface CategoryCreationInputBoundary {
    CategoryCreationResponseModel create(CategoryCreationRequestModel requestModel);
}
