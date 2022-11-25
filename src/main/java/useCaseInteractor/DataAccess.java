package useCaseInteractor;

import boundary.AddScheduleItemInputBoundary;
import com.mongodb.client.MongoCollection;
import entity.CommonScheduleItem;
import entity.CommonTask;
import requestModel.ScheduleItemRequestModel;
import requestModel.TaskRequestModel;
import responseModel.ScheduleItemResponseModel;

import java.util.ArrayList;

public interface DataAccess {
    void savetoDB(ScheduleItemRequestModel requestModel);

    ArrayList<CommonScheduleItem> getUserSchedule(ScheduleItemRequestModel requestModel);

    // should return some type of mongoDB, probably a collection
    ArrayList<CommonTask> getUserTask(TaskRequestModel requestModel);

    void deleteFromDB(ScheduleItemRequestModel requestModel);
}
