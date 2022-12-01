package presenter;

import responseModel.Category.CategoryResponseModel;


public interface AddCategoryPresenter {
    CategoryResponseModel prepareSuccessView(CategoryResponseModel categoryResponseModel);


    CategoryResponseModel prepareFailView(String error);
}
