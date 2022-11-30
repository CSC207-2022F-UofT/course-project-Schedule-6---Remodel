package controller.Category;

import boundary.Category.CategoryCreationInputBoundary;
import presenter.AddCateogoryPresenter;
import requestModel.CategoryCreationRequestModel;
import responseModel.Category.CategoryCreationResponseModel;

public class AddCategoryController {
    final  CategoryCreationInputBoundary categoryCreationInputBoundary;

    final AddCateogoryPresenter presenter;

    public AddCategoryController(CategoryCreationInputBoundary categoryCreationInputBoundary, AddCateogoryPresenter presenter) {
        this.categoryCreationInputBoundary = categoryCreationInputBoundary;
        this.presenter = presenter;
    }

    public CategoryCreationResponseModel create(String name, boolean status) {
        if (name.isBlank()) {
            return presenter.prepareFailView("Please fill in category name");
        } else if (!nameChecker(name)) {
            return presenter.prepareFailView("Category already exists");
        }
        CategoryCreationRequestModel inputData = new CategoryCreationRequestModel(name, status);
        return categoryCreationInputBoundary.create(inputData);
    }

    //need to implement nameChecker
    public boolean nameChecker(String name) {

        return true;
    }
    //cont..
}
