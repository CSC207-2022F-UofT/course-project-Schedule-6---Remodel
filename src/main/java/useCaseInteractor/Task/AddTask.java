package useCaseInteractor.Task;

import boundary.Task.AddTaskBoundary;
import entity.Task.Task;
import entity.Task.TaskFactory;
import requestModel.TaskRequestModel;
import responseModel.Task.TaskResponseModel;
import useCaseInteractor.DataAccess;

public class AddTask implements AddTaskBoundary {

    final DataAccess dataAccess;
    final TaskFactory TaskFactory;
    final presenter.AddTaskPresenter AddTaskPresenter;

    public AddTask(DataAccess dataAccess, entity.Task.TaskFactory taskFactory, presenter.AddTaskPresenter addTaskPresenter) {
        this.dataAccess = dataAccess;
        TaskFactory = taskFactory;
        AddTaskPresenter = addTaskPresenter;
    }

    public TaskResponseModel create(TaskRequestModel inputData) {
        Task Task = TaskFactory.create(inputData.getTitle(),
                inputData.getDate(), inputData.getPrivacySetting(), inputData.getCategory());

        dataAccess.setTask(inputData);

        TaskResponseModel responseModel = new TaskResponseModel(Task.getTitle(),
                Task.getDate(), Task.getPrivacySetting(), Task.getCategory());
        return AddTaskPresenter.prepareSuccessView(responseModel);
    }
}