package controller.Category;

import boundary.Category.CategoryCreationInputBoundary;
import presenter.AddCategoryPresenter;
import requestModel.CategoryCreationRequestModel;
import responseModel.Category.CategoryCreationResponseModel;

public class CategoryCreationController {
    final CategoryCreationInputBoundary addCategoryInputBoundary;

    final AddCategoryPresenter presenter;

    public CategoryCreationController(CategoryCreationInputBoundary inputBoundary, AddCategoryPresenter presenter){
        this.addCategoryInputBoundary = inputBoundary;
        this.presenter = presenter;
    }

    public CategoryCreationResponseModel create(String title, Boolean status){
        if (title.isBlank() || (status == null)){
            return presenter.prepareFailView("Please Fill in ALl Fields");
        }

        CategoryCreationRequestModel newInputData = new CategoryCreationRequestModel(title, status);
        return addCategoryInputBoundary.create(newInputData);

    }

}
