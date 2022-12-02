package useCaseInteractor.Task;

import boundary.Task.DeleteTaskInputBoundary;
import presenter.TaskPresenter;
import requestModel.TaskRequestModel;
import responseModel.Task.TaskResponseModel;
import useCaseInteractor.DataAccess;

public class DeleteTask implements DeleteTaskInputBoundary {
    final DataAccess dataAccess;

    final TaskPresenter presenter;

    public DeleteTask(DataAccess dataAccess, TaskPresenter presenter) {
        this.dataAccess = dataAccess;
        this.presenter = presenter;
    }

    public TaskResponseModel delete(TaskRequestModel inputData){

        TaskResponseModel responseModel = new TaskResponseModel(inputData.getDescription(), inputData.getDate(),
                inputData.getPrivacy(), inputData.getCategory());

        dataAccess.deleteTask(responseModel);

        return presenter.prepareSuccessView(responseModel);
    }
}
