package useCaseInteractor.Task;
import requestModel.TaskRequestModel;
import responseModel.Task.TaskResponseModel;
import useCaseInteractor.DataAccess;
import boundary.Task.DeleteTaskInputBoundary;
public class DeleteTask implements DeleteTaskInputBoundary {
    final DataAccess dataAccess;

    public DeleteTask (DataAccess dataAccess){
        this.dataAccess = dataAccess;
    }


        @Override
        public TaskResponseModel delete(TaskRequestModel inputData) {
            dataAccess.deleteTask(inputData);
            return null;
        }
    }
