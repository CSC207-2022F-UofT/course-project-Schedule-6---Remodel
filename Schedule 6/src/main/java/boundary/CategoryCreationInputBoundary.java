package boundary;

import useCaseInteractor.CategoryCreationRequestModel;
import useCaseInteractor.CategoryCreationResponseModel;

public interface CategoryCreationInputBoundary {
    CategoryCreationResponseModel create(CategoryCreationRequestModel requestModel);
}
