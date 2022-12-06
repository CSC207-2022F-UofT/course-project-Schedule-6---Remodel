package useCaseInteractor.Task;

import boundary.Task.DeleteTaskInputBoundary;
import presenter.TaskPresenterInterface;
import requestModel.TaskRequestModel;
import responseModel.Task.TaskResponseModel;
import useCaseInteractor.DataAccess;

public class DeleteTask implements DeleteTaskInputBoundary {
    final DataAccess dataAccess;

    final TaskPresenterInterface presenter;

    public DeleteTask(DataAccess dataAccess, TaskPresenterInterface presenter) {
        this.dataAccess = dataAccess;
        this.presenter = presenter;
    }

    public TaskResponseModel delete(TaskRequestModel inputData){

        TaskResponseModel responseModel = new TaskResponseModel(inputData.getDescription(), inputData.getDate(),
                inputData.getCategory());

        dataAccess.deleteTask(responseModel);

        return presenter.prepareSuccessView(responseModel);
    }
}
