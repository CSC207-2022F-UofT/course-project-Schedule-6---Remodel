package useCaseInteractor;

import requestModel.ImportRequestModel;
import requestModel.EventItemRequestModel;
import responseModel.Event.EventItemResponseModel;
import responseModel.Task.TaskResponseModel;

import java.util.ArrayList;

public interface DataAccess {

    void createUser(String password, String fName, String lName);

    boolean getUserExist(String username);

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

    Object getUserData();

    void setPassword(String password);

    boolean checkPassword(String password);
}
