package boundary.Category;

import requestModel.CategoryRequestModel;
import requestModel.ScheduleItemRequestModel;
import responseModel.Category.CategoryResponseModel;

public interface EditCategoryInputBoundary {
    CategoryResponseModel edit(CategoryRequestModel newInputData, ScheduleItemRequestModel oldInputData);
}
