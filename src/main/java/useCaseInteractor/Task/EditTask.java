package useCaseInteractor.Task;

import presenter.TaskPresenter;
import requestModel.TaskRequestModel;
import responseModel.Task.TaskResponseModel;
import useCaseInteractor.DataAccess;

public class EditTask implements  boundary.Task.EditTaskInputBoundary{
    final DataAccess dataAccess;

    final TaskPresenter taskPresenter;


    public EditTask(DataAccess dataAccess, TaskPresenter taskPresenter) {
        this.dataAccess = dataAccess;
        this.taskPresenter = taskPresenter;
    }

    public TaskResponseModel edit(TaskRequestModel newInputdata, TaskRequestModel oldInputData) {


        TaskResponseModel newresponseModel = new TaskResponseModel(newInputdata.getDescription(), newInputdata.getDate()
                , newInputdata.getCategory());

        TaskResponseModel oldresponseModel = new TaskResponseModel(oldInputData.getDescription(), oldInputData.getDate()
                , oldInputData.getCategory());

        dataAccess.deleteTask(oldresponseModel);
        dataAccess.setTask(newresponseModel);

        return taskPresenter.prepareSuccessView(newresponseModel);
    }
}
