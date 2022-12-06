package useCaseInteractor.Task;

import presenter.TaskPresenterInterface;
import requestModel.TaskRequestModel;
import responseModel.Task.TaskResponseModel;
import useCaseInteractor.DataAccess;

public class EditTask implements  boundary.Task.EditTaskInputBoundary{
    final DataAccess dataAccess;

    final TaskPresenterInterface taskPresenterInterface;


    public EditTask(DataAccess dataAccess, TaskPresenterInterface taskPresenterInterface) {
        this.dataAccess = dataAccess;
        this.taskPresenterInterface = taskPresenterInterface;
    }

    public TaskResponseModel edit(TaskRequestModel newInputdata, TaskRequestModel oldInputData) {


        TaskResponseModel newresponseModel = new TaskResponseModel(newInputdata.getDescription(), newInputdata.getDate()
                , newInputdata.getCategory());

        TaskResponseModel oldresponseModel = new TaskResponseModel(oldInputData.getDescription(), oldInputData.getDate()
                , oldInputData.getCategory());

        dataAccess.deleteTask(oldresponseModel);
        dataAccess.setTask(newresponseModel);

        return taskPresenterInterface.prepareSuccessView(newresponseModel);
    }
}
