package boundary.Category;

import requestModel.CategoryRequestModel;
import responseModel.Category.CategoryResponseModel;

public interface CategoryCreationInputBoundary {
    CategoryResponseModel create(CategoryRequestModel requestModel);
}
