package useCaseInteractor.Task;

import boundary.Task.UpdateTaskItemInputBoundary;
import entity.Task.Task;
import entity.Task.TaskFactory;
import requestModel.TaskRequestModel;
import responseModel.Task.TaskResponseModel;
import useCaseInteractor.DataAccess;

public class UpdateTask implements UpdateTaskItemInputBoundary {
    final DataAccess dataAccess;

    final TaskFactory taskFactory;


    public UpdateTask(DataAccess dataAccess, TaskFactory taskFactory) {
        this.dataAccess = dataAccess;
        this.taskFactory = taskFactory;
    }

    /**
     * Method create() overrides its interfaces' method (UpdateTaskInputBoundary) and is called in the
     * TimetableController layer. This method creates a Task entity, and stores that Task
     * entity into our MongoDB database through the dataAccess interface.
     *
     * @param inputData the TaskRequestModel that contains a single task data
     */
    @Override
    public void create(TaskRequestModel inputData) {
        Task task = taskFactory.create(inputData.getDescription(), inputData.getDate(), inputData.getCategory());

        TaskResponseModel taskResponseModel = new TaskResponseModel(task.getDescription(), task.getDate(),
                task.getCategory());

        dataAccess.setTask(taskResponseModel);
    }
}
