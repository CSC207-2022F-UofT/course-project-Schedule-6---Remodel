package useCaseInteractor;

import requestModel.ImportRequestModel;
import requestModel.EventItemRequestModel;
import responseModel.Event.EventItemResponseModel;
import responseModel.Task.TaskResponseModel;

import java.util.ArrayList;

public interface DataAccess {

    boolean createUser(String password, String fName, String lName);

    boolean eventExists(EventItemRequestModel request);

    void resetEvents();

    void resetTask();

    void setEvent(EventItemResponseModel responseModel);

    ArrayList<Object> getSingleEvent(EventItemResponseModel responseModel);

    void setImportEvents(ImportRequestModel requestModel);

    ArrayList<ArrayList<Object>> getUserEvents();

    void deleteEventItem(EventItemResponseModel responseModel);

    void setTask(TaskResponseModel responseModel);

    ArrayList<Object> getSingleTask(TaskResponseModel responseModel);

    ArrayList<ArrayList<Object>> getUserTasks();

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
