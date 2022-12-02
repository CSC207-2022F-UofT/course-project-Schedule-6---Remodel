package useCaseInteractor;

import requestModel.ScheduleItemRequestModel;
import requestModel.TaskRequestModel;
import responseModel.Task.TaskResponseModel;

import java.util.ArrayList;

public interface DataAccess {

    boolean createUser(String password, String fName, String lName);

    void setSchedule(ScheduleItemRequestModel requestModel);

    ArrayList<Object> getSingleSchedule(ScheduleItemRequestModel requestModel);

    ArrayList<ArrayList<Object>> getUserEntireSchedule();

    void deleteScheduleItem(ScheduleItemRequestModel requestModel);

    void setTask(TaskRequestModel requestModel);

    ArrayList<Object> getSingleTask(TaskRequestModel requestModel);

    ArrayList<ArrayList<Object>> getUserEntireTask();

    void deleteTask(TaskRequestModel requestModel);

    boolean getUserExist(String username);

    boolean getUserExist();

    Object getUserData();

    void setPassword(String password);

    Object getFollowing();

    void appendFollowing(String username);

    boolean checkPassword(String password);

    void setFollowing(ArrayList<String> following);

    Object getRequests();

    void appendRequests(String username);

    //sets a new request list when a request is accepted or declined
    void setRequests(ArrayList<String> usernames);

}
