package database;

import com.mongodb.client.MongoClient;
import entity.CommonScheduleItem;
import entity.CommonTask;
import requestModel.ScheduleItemRequestModel;
import requestModel.TaskRequestModel;
import useCaseInteractor.DataAccess;
import java.util.ArrayList;

public class MongoDBAccess implements DataAccess {

    private final MongoClient mongoClient;
    private final String username;

    public MongoDBAccess(MongoClient mongoClient, String username) {

        this.mongoClient = mongoClient;
        this.username = username;
    }


    @Override
    public void savetoDB(ScheduleItemRequestModel requestModel) {
        // needs to find the user to save to
        //Will give each user an id, we'll use the id to run through DB
    }

    @Override
    public ArrayList<CommonScheduleItem> getUserSchedule(ScheduleItemRequestModel requestModel) {
        return null;
    }

    @Override
    public ArrayList<CommonTask> getUserTask(TaskRequestModel requestModel) {
        return null;
    }

    @Override
    public void deleteFromDB(ScheduleItemRequestModel requestModel) {

    }

    @Override
    public boolean getUserExist(String username){
        return false;
    }

    @Override
    public String getUsername(){
        return null;
    }

    @Override
    public void setUsername(String username){

    }

    @Override
    public String getFollowing(){
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
