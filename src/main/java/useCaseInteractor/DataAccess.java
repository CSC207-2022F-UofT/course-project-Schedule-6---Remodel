package useCaseInteractor;

import boundary.AddScheduleItemInputBoundary;
import com.mongodb.client.MongoCollection;
import entity.CommonScheduleItem;
import entity.CommonTask;
import entity.User;
import requestModel.ScheduleItemRequestModel;
import requestModel.TaskRequestModel;
import responseModel.ScheduleItemResponseModel;

import java.util.ArrayList;

public interface DataAccess {

    void setSchedule(ScheduleItemRequestModel requestModel);

    CommonScheduleItem getSingleSchedule(ScheduleItemRequestModel requestModel);

    ArrayList<CommonScheduleItem> getUserEntireSchedule();

    void setTask(TaskRequestModel requestModel);

    CommonTask getSingleTask(TaskRequestModel requestModel);

    ArrayList<CommonTask> getUserEntireTask();

    void savetoDB(ScheduleItemRequestModel requestModel);

    ArrayList<CommonScheduleItem> getUserSchedule(ScheduleItemRequestModel requestModel);

    ArrayList<CommonTask> getUserTask(TaskRequestModel requestModel);

    void deleteFromDB(ScheduleItemRequestModel requestModel);

    boolean getUserExist(String username);

    Object getUserData();

    void setPassword(String password);

    Object getFollowing();

    void appendFollowing(String username);

    Object getRequests();

    void appendRequests(String username);
}
