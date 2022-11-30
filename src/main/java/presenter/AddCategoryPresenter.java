package presenter;

import responseModel.Category.CategoryCreationResponseModel;


public interface AddCategoryPresenter {
    CategoryCreationResponseModel prepareSuccessView(CategoryCreationResponseModel categoryCreationResponseModel);


    CategoryCreationResponseModel prepareFailView(String error);
}
