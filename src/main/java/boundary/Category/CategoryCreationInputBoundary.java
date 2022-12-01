package boundary.Category;

import requestModel.CategoryCreationRequestModel;
import responseModel.Category.CategoryResponseModel;

public interface CategoryCreationInputBoundary {
    CategoryResponseModel create(CategoryCreationRequestModel requestModel);
}
