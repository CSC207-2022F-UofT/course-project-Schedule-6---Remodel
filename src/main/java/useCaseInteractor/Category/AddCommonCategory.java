package useCaseInteractor.Category;

import boundary.Category.CategoryCreationInputBoundary;
import entity.Category.Category;
import entity.Category.CategoryFactory;
import presenter.AddCategoryPresenter;
import requestModel.CategoryCreationRequestModel;
import responseModel.Category.CategoryCreationResponseModel;
import useCaseInteractor.DataAccess;

public class AddCommonCategory implements CategoryCreationInputBoundary {
    final DataAccess dataAccess;

    final CategoryFactory categoryFactory;

    final AddCategoryPresenter categoryPresenter;

    public AddCommonCategory(DataAccess dataAccess, CategoryFactory categoryFactory, AddCategoryPresenter categoryPresenter) {
        this.dataAccess = dataAccess;
        this.categoryFactory = categoryFactory;
        this.categoryPresenter = categoryPresenter;
    }

    @Override
    public CategoryCreationResponseModel create(CategoryCreationRequestModel requestModel) {
        Category category = categoryFactory.create(requestModel.getName(), requestModel.getStatus());
        dataAccess.setCategory(requestModel);
        CategoryCreationResponseModel responseModel = new CategoryCreationResponseModel(category.getName(), category.getStatus());
        return categoryPresenter.prepareSuccessView(responseModel);
    }
}
