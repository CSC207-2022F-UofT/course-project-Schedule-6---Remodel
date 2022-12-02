package useCaseInteractor.Task;

import entity.Task.Task;
import entity.Task.TaskFactory;
import presenter.TaskPresenter;
import requestModel.TaskRequestModel;
import responseModel.Task.TaskResponseModel;
import useCaseInteractor.DataAccess;

public class AddTask implements boundary.Task.AddTaskItemInputBoundary{
    final DataAccess dataAccess;

    final TaskFactory taskFactory;

    final TaskPresenter taskPresenter;

    public AddTask(DataAccess dataAccess, TaskFactory taskFactory, TaskPresenter taskPresenter) {
        this.dataAccess = dataAccess;
        this.taskFactory = taskFactory;
        this.taskPresenter = taskPresenter;
    }

    @Override
    public TaskResponseModel create(TaskRequestModel inputData) {
        Task task = taskFactory.create(inputData.getTitle(), inputData.getDate(),
                inputData.getPrivacy(), inputData.getCategory());
        dataAccess.setTask(inputData);

        TaskResponseModel taskResponseModel = new TaskResponseModel(task.getTitle(),
                task.getDate(), task.getPrivacySetting(), task.getCategory());

        return taskPresenter.prepareSuccessView(taskResponseModel);
    }
}
