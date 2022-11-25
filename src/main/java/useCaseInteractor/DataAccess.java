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

    boolean getUserExist(String username);

    ArrayList<User> getUserData();

    void setUsername(String username);

    ArrayList<User> getFollowing();

    void appendFollowing(String username);

    String getRequests();

    void appendRequests(String username);
}
