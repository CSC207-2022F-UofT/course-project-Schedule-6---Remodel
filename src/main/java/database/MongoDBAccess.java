package database;

import com.mongodb.DBCollection;
import com.mongodb.client.MongoClient;
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
    public ArrayList<User> getUserData(){
        return null;
    }

    //public

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
