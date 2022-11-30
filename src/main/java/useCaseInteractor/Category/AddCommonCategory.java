package useCaseInteractor.Category;

import boundary.Category.CategoryCreationInputBoundary;
import entity.Category.Category;
import entity.Category.CategoryFactory;
import presenter.AddCategoryPresenter;
import requestModel.CategoryRequestModel;
import responseModel.Category.CategoryResponseModel;
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
    public CategoryResponseModel create(CategoryRequestModel requestModel) {
        Category category = categoryFactory.create(requestModel.getName(), requestModel.getStatus());
        dataAccess.setCategory(requestModel);
        CategoryResponseModel responseModel = new CategoryResponseModel(category.getName(), category.isStatus());
        return categoryPresenter.prepareSuccessView(responseModel);
    }
}
