package presenter;

import responseModel.Category.CategoryCreationResponseModel;

public interface AddCateogoryPresenter {
    CategoryCreationResponseModel prepareSuccessView(CategoryCreationResponseModel categoryCreationResponseModel);

    CategoryCreationResponseModel prepareFailView(String error);
}
