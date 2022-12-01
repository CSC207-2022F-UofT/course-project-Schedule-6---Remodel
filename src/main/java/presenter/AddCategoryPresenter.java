package presenter;

<<<<<<< HEAD
import responseModel.Category.CategoryCreationResponseModel;


public interface AddCategoryPresenter {
    CategoryCreationResponseModel prepareSuccessView(CategoryCreationResponseModel categoryCreationResponseModel);


    CategoryCreationResponseModel prepareFailView(String error);
=======
import responseModel.Category.CategoryResponseModel;


public interface AddCategoryPresenter {
    CategoryResponseModel prepareSuccessView(CategoryResponseModel categoryResponseModel);


    CategoryResponseModel prepareFailView(String error);
>>>>>>> origin/feature-8-user
}
