package presenter;

import responseModel.Category.CategoryCreationResponseModel;
import responseModel.Schedule.ScheduleItemResponseModel;

public interface AddCategoryPresenter {
    CategoryCreationResponseModel prepareSuccessView(ScheduleItemResponseModel categoryResponseModel);

    CategoryCreationResponseModel prepareFailView(String error);
}
