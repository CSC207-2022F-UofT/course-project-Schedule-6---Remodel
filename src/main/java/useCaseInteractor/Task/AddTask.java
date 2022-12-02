package useCaseInteractor.Task;

import entity.Task.CommonTaskFactory;
import entity.Task.Task;
import entity.Task.TaskFactory;
import presenter.AddTaskPresenter;
import requestModel.TaskRequestModel;
import responseModel.Task.TaskResponseModel;
import useCaseInteractor.DataAccess;

public class AddTask implements boundary.Task.AddTaskItemInputBoundary{
    final DataAccess dataAccess;

    final TaskFactory taskFactory;

    final AddTaskPresenter addTaskPresenter;

    public AddTask(DataAccess dataAccess, TaskFactory taskFactory, AddTaskPresenter addTaskPresenter) {
        this.dataAccess = dataAccess;
        this.taskFactory = taskFactory;
        this.addTaskPresenter = addTaskPresenter;
    }

    @Override
    public TaskResponseModel create(TaskRequestModel inputData) {
        Task task = taskFactory.create(inputData.getTitle(), inputData.getDate(),
                inputData.getPrivacy(), inputData.getCategory());
        dataAccess.setTask(inputData);

        TaskResponseModel taskResponseModel = new TaskResponseModel(task.getTitle(),
                task.getDate(), task.getPrivacySetting(), task.getCategory());

        return addTaskPresenter.prepareSuccessView(taskResponseModel);
    }
}
