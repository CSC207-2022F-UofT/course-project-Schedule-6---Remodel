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

    void saveSchedule(ScheduleItemRequestModel requestModel);

    void saveTask(TaskRequestModel requestModel);

    ArrayList<CommonScheduleItem> getUserEntireSchedule(ScheduleItemRequestModel requestModel);

    // should return some type of mongoDB, probably a collection
    ArrayList<CommonTask> getUserEntireTask(TaskRequestModel requestModel);

    void deleteFromDB(ScheduleItemRequestModel requestModel);


    boolean getUserExist(String username);

    ArrayList<User> getUserData();

    void setUsername(String username);

    ArrayList<User> getFollowing();

    void appendFollowing(String username);

    String getRequests();

    void appendRequests(String username);
}
