package useCaseInteractor.Task;

import presenter.WeekViewPresenter;
import requestModel.ScheduleItemRequestModel;
import requestModel.TaskRequestModel;
import responseModel.Schedule.ScheduleItemResponseModel;
import responseModel.Task.TaskResponseModel;
import useCaseInteractor.DataAccess;
import boundary.Task.DeleteTaskBoundary;
public class DeleteTask implements DeleteTaskBoundary {

    final DataAccess dataAccess;

    // need to add CommonUser variable so it knows where to add the ScheduleItem

    public DeleteTask(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }


    @Override
    public TaskResponseModel delete(TaskRequestModel inputData) {
        dataAccess.deleteTask(inputData);
        return null;
    }
}
