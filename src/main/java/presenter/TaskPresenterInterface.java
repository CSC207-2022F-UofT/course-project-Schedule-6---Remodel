package presenter;

import responseModel.Task.TaskResponseModel;

public interface TaskPresenterInterface {
    TaskResponseModel prepareSuccessView(TaskResponseModel taskItemResponseModel);
}
