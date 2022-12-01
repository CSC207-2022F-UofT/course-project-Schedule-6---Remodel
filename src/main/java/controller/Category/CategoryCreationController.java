package controller.Category;

import boundary.Category.CategoryCreationInputBoundary;
import presenter.AddCategoryPresenter;
import requestModel.CategoryRequestModel;
import responseModel.Category.CategoryResponseModel;

public class CategoryCreationController {
    final CategoryCreationInputBoundary addCategoryInputBoundary;

    final AddCategoryPresenter presenter;

    public CategoryCreationController(CategoryCreationInputBoundary inputBoundary, AddCategoryPresenter presenter){
        this.addCategoryInputBoundary = inputBoundary;
        this.presenter = presenter;
    }

    public CategoryResponseModel create(String title, Boolean status){
        if (title.isBlank() || (status == null)){
            return presenter.prepareFailView("Please Fill in ALl Fields");
        }

        CategoryRequestModel newInputData = new CategoryRequestModel(title, status);
        return addCategoryInputBoundary.create(newInputData);

    }

}
