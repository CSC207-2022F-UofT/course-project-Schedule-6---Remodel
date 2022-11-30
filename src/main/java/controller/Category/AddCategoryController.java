package controller.Category;

import boundary.Category.CategoryCreationInputBoundary;
import presenter.AddCateogoryPresenter;

public class AddCategoryController {
    final  CategoryCreationInputBoundary categoryCreationInputBoundary;

    final AddCateogoryPresenter presenter;

    public AddCategoryController(CategoryCreationInputBoundary categoryCreationInputBoundary, AddCateogoryPresenter presenter) {
        this.categoryCreationInputBoundary = categoryCreationInputBoundary;
        this.presenter = presenter;
    }

    //cont..
}
