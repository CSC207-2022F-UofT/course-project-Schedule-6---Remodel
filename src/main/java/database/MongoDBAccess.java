package database;

import com.mongodb.DBCollection;
import entity.CommonScheduleItem;
import entity.CommonTask;
import requestModel.ScheduleItemRequestModel;
import requestModel.TaskRequestModel;
import useCaseInteractor.DataAccess;
import java.util.ArrayList;
import entity.User;

public class MongoDBAccess implements DataAccess {

    private final String username;

    private final DBCollection collection;

    public MongoDBAccess(DBCollection collection, String username) {

        this.username = username;
        this.collection = collection;
    }

    @Override
    public void setSchedule(ScheduleItemRequestModel requestModel) {

    }

    @Override
    public CommonScheduleItem getSingleSchedule(ScheduleItemRequestModel requestModel) {
        return null;
    }

    @Override
    public ArrayList<CommonScheduleItem> getUserEntireSchedule() {
        return null;
    }

    @Override
    public void setTask(TaskRequestModel requestModel) {
    }

    @Override
    public CommonTask getSingleTask(TaskRequestModel requestModel) {
        return null;
    }

    @Override
    public ArrayList<CommonTask> getUserEntireTask() {
        return null;
    }

    @Override
    public boolean getUserExist(String username){
        return false;
    }

    @Override
    public ArrayList<User> getUserData(){
        return null;
    }

    @Override
    public void setUsername(String username){
    }

    @Override
    public ArrayList<User> getFollowing(){
        return null;
    }

    @Override
    public void appendFollowing(String username){
    }

    @Override
    public String getRequests(){
        return null;
    }

    @Override
    public void appendRequests(String username){
    }
}
