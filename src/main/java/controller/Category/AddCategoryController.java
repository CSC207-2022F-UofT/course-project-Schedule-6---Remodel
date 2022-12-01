package controller.Category;

import boundary.Category.CategoryCreationInputBoundary;
import presenter.AddCategoryPresenter;
import requestModel.CategoryCreationRequestModel;
<<<<<<< HEAD
import responseModel.Category.CategoryCreationResponseModel;
=======
import responseModel.Category.CategoryResponseModel;
>>>>>>> origin/feature-8-user

public class AddCategoryController {
    final  CategoryCreationInputBoundary categoryCreationInputBoundary;

    final AddCategoryPresenter presenter;

    public AddCategoryController(CategoryCreationInputBoundary categoryCreationInputBoundary, AddCategoryPresenter presenter) {
        this.categoryCreationInputBoundary = categoryCreationInputBoundary;
        this.presenter = presenter;
    }

<<<<<<< HEAD
    public CategoryCreationResponseModel create(String name, boolean status) {
=======
    public CategoryResponseModel create(String name, boolean status) {
>>>>>>> origin/feature-8-user
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
