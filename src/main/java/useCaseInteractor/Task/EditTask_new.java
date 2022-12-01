package useCaseInteractor.Task;
import boundary.Task.EditTaskInputBoundary;
import requestModel.TaskRequestModel;
import responseModel.Task.TaskResponseModel;
import useCaseInteractor.DataAccess;
public class EditTask_new implements EditTaskInputBoundary {
    final DataAccess dataAccess;

    public EditTask_new(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    @Override
    public TaskResponseModel edit(TaskRequestModel newInputData, TaskRequestModel oldInputData) {
        dataAccess.deleteTask(oldInputData);
        dataAccess.setTask(oldInputData);
        return null;
    }
}
