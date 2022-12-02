package presenter;

import responseModel.Task.TaskResponseModel;

public interface TaskPresenter {
    TaskResponseModel prepareSuccessView(TaskResponseModel taskItemResponseModel);

    TaskResponseModel prepareFailView(String error);
}
