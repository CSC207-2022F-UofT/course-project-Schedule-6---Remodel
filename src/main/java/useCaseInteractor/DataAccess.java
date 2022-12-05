package useCaseInteractor;

import requestModel.ImportRequestModel;
import requestModel.ScheduleItemRequestModel;
import requestModel.TaskRequestModel;
import responseModel.Schedule.ScheduleItemResponseModel;
import responseModel.Task.TaskResponseModel;

import java.util.ArrayList;

public interface DataAccess {

    boolean createUser(String password, String fName, String lName);

    String getFnameLname();

    void resetSchedule();

    void resetTask();

    void setSchedule(ScheduleItemResponseModel responseModel);

    ArrayList<Object> getSingleSchedule(ScheduleItemResponseModel responseModel);

    void setImportSchedule(ImportRequestModel requestModel);

    ArrayList<ArrayList<Object>> getUserEntireSchedule();

    void deleteScheduleItem(ScheduleItemResponseModel responseModel);

    void setTask(TaskResponseModel responseModel);

    ArrayList<Object> getSingleTask(TaskResponseModel responseModel);

    ArrayList<ArrayList<Object>> getUserEntireTask();

    void deleteTask(TaskResponseModel responseModel);

    boolean getTaskExist(TaskResponseModel responseModel);

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
