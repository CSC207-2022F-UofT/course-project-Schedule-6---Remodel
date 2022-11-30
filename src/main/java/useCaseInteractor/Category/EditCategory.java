package useCaseInteractor.Category;

import presenter.EditCategoryPresenter;
import requestModel.CategoryRequestModel;
import responseModel.Category.CategoryResponseModel;
import useCaseInteractor.DataAccess;

public class EditCategory {
    final DataAccess dataAccess;

    final EditCategoryPresenter categoryPresenter;

    public EditCategory(DataAccess dataAccess, EditCategoryPresenter categoryPresenter) {
        this.dataAccess = dataAccess;
        this.categoryPresenter = categoryPresenter;
    }

    public CategoryResponseModel edit(CategoryRequestModel newInputData, CategoryRequestModel oldInputData){

        return null;
    }
}
