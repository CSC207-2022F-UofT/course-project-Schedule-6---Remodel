package useCaseInteractor.Task;

import entity.Task.Task;
import entity.Task.TaskFactory;
import requestModel.TaskRequestModel;
import responseModel.Task.TaskResponseModel;
import useCaseInteractor.DataAccess;

public class AddTask implements boundary.Task.AddTaskItemInputBoundary{
    final DataAccess dataAccess;

    final TaskFactory taskFactory;


    public AddTask(DataAccess dataAccess, TaskFactory taskFactory) {
        this.dataAccess = dataAccess;
        this.taskFactory = taskFactory;
    }

    @Override
    public void create(TaskRequestModel inputData) {
        Task task = taskFactory.create(inputData.getDescription(), inputData.getDate(), inputData.getCategory());

        TaskResponseModel taskResponseModel = new TaskResponseModel(task.getDescription(), task.getDate(),
                task.getCategory());

        dataAccess.setTask(taskResponseModel);
    }
}
