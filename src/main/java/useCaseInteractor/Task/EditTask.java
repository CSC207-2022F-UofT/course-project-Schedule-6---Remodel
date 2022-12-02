package useCaseInteractor.Task;

import presenter.AddTaskPresenter;
import requestModel.TaskRequestModel;
import responseModel.Task.TaskResponseModel;
import useCaseInteractor.DataAccess;

public class EditTask {
    final DataAccess dataAccess;

    final AddTaskPresenter taskPresenter;


    public EditTask(DataAccess dataAccess, AddTaskPresenter taskPresenter) {
        this.dataAccess = dataAccess;
        this.taskPresenter = taskPresenter;
    }

    public TaskResponseModel edit(TaskRequestModel newInputdata, TaskRequestModel oldInputData) {
        dataAccess.deleteTask(oldInputData);
        dataAccess.setTask(newInputdata);

        TaskResponseModel responseModel = new TaskResponseModel(newInputdata.getTitle(), newInputdata.getDate(),
                newInputdata.getPrivacy(), newInputdata.getCategory());
        return taskPresenter.prepareSuccessView(responseModel);
    }
}
