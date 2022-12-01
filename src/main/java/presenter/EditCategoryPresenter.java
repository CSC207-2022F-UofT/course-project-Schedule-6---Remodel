package presenter;

import responseModel.Category.CategoryResponseModel;

public interface EditCategoryPresenter {
    CategoryResponseModel prepareSuccessView(CategoryResponseModel categoryResponseModel);

    CategoryResponseModel prepareFailView(String error);
}
