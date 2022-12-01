package controller.Category;

import boundary.Category.CategoryCreationInputBoundary;
import presenter.AddCategoryPresenter;
import requestModel.CategoryRequestModel;
import responseModel.Category.CategoryResponseModel;

public class AddCategoryController {
    final  CategoryCreationInputBoundary categoryCreationInputBoundary;

    final AddCategoryPresenter presenter;

    public AddCategoryController(CategoryCreationInputBoundary categoryCreationInputBoundary, AddCategoryPresenter presenter) {
        this.categoryCreationInputBoundary = categoryCreationInputBoundary;
        this.presenter = presenter;
    }

    public CategoryResponseModel create(String name, boolean status) {
        if (name.isBlank()) {
            return presenter.prepareFailView("Please fill in category name");
        } else if (!nameChecker(name)) {
            return presenter.prepareFailView("Category already exists");
        }
        CategoryRequestModel inputData = new CategoryRequestModel(name, status);
        return categoryCreationInputBoundary.create(inputData);
    }

    //need to implement nameChecker
    public boolean nameChecker(String name) {

        return true;
    }
    //cont..
}
