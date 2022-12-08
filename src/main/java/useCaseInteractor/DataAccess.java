package useCaseInteractor;

import requestModel.EventItemRequestModel;
import requestModel.ImportRequestModel;
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

    void setImportEvents(ImportRequestModel requestModel);

    ArrayList<ArrayList<Object>> getUserEvents();

    void setTask(TaskResponseModel responseModel);

    ArrayList<ArrayList<Object>> getUserTasks();

    void setPassword(String password);

    boolean checkPassword(String password);
}
