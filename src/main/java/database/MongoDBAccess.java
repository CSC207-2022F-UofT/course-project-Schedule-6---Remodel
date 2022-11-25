package database;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.client.MongoClient;
import entity.CommonScheduleItem;
import entity.CommonTask;
import requestModel.ScheduleItemRequestModel;
import requestModel.TaskRequestModel;
import useCaseInteractor.DataAccess;

import java.util.ArrayList;

public class MongoDBAccess implements DataAccess {

    private final DBCollection collection;

    private final String username;

    public MongoDBAccess(DBCollection collection, String username) {
        this.collection = collection;
        this.username = username;
    }

    @Override
    public void saveSchedule(ScheduleItemRequestModel requestModel) {

    }

    @Override
    public void saveTask(TaskRequestModel requestModel) {}

    @Override
    public ArrayList<CommonScheduleItem> getUserEntireSchedule(ScheduleItemRequestModel requestModel) {
        return null;
    }

    @Override
    public ArrayList<CommonTask> getUserEntireTask(TaskRequestModel requestModel) {
        return null;
    }

    @Override
    public void deleteFromDB(ScheduleItemRequestModel requestModel) {
    }
}
