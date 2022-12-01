package controller.Category;

import boundary.Category.CategoryCreationInputBoundary;
import presenter.AddCategoryPresenter;
import requestModel.CategoryCreationRequestModel;
<<<<<<< HEAD
import responseModel.Category.CategoryCreationResponseModel;
=======
import responseModel.Category.CategoryResponseModel;
>>>>>>> origin/feature-8-user

public class CategoryCreationController {
    final CategoryCreationInputBoundary addCategoryInputBoundary;

    final AddCategoryPresenter presenter;

    public CategoryCreationController(CategoryCreationInputBoundary inputBoundary, AddCategoryPresenter presenter){
        this.addCategoryInputBoundary = inputBoundary;
        this.presenter = presenter;
    }

<<<<<<< HEAD
    public CategoryCreationResponseModel create(String title, Boolean status){
=======
    public CategoryResponseModel create(String title, Boolean status){
>>>>>>> origin/feature-8-user
        if (title.isBlank() || (status == null)){
            return presenter.prepareFailView("Please Fill in ALl Fields");
        }

        CategoryCreationRequestModel newInputData = new CategoryCreationRequestModel(title, status);
        return addCategoryInputBoundary.create(newInputData);

    }

}
