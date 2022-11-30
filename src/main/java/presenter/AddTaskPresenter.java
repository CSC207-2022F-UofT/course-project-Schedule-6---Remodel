package presenter;

import responseModel.Task.TaskResponseModel;

public interface AddTaskPresenter {
    TaskResponseModel prepareSuccessView(TaskResponseModel taskItemResponseModel);

    TaskResponseModel prepareFailView(String error);
}
