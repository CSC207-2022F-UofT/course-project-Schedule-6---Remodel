package useCaseInteractor;

import requestModel.ScheduleItemRequestModel;
import requestModel.TaskRequestModel;

import java.util.ArrayList;

public interface DataAccess {

    void setSchedule(ScheduleItemRequestModel requestModel);

    ArrayList<Object> getSingleSchedule(ScheduleItemRequestModel requestModel);

    ArrayList<ArrayList<Object>> getUserEntireSchedule();

    void deleteScheduleItem(ScheduleItemRequestModel requestModel);

    void setTask(TaskRequestModel requestModel);

    ArrayList<Object> getSingleTask(TaskRequestModel requestModel);

    ArrayList<ArrayList<Object>> getUserEntireTask();

    boolean getUserExist(String username);

    Object getUserData();

    void setPassword(String password);

    Object getFollowing();

    void appendFollowing(String username);

    Object getRequests();

    void appendRequests(String username);
}
