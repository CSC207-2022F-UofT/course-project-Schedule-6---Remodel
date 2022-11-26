package database;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import entity.CommonScheduleItem;
import entity.CommonTask;
import requestModel.ScheduleItemRequestModel;
import requestModel.TaskRequestModel;
import useCaseInteractor.DataAccess;
import java.util.ArrayList;

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
        return this.collection.findOne(username) != null;
    }

    @Override
    public DBObject getUserData(){
        return collection.findOne(this.username);
    }

    @Override
    public void setPassword(String password){
        DBObject query = new BasicDBObject("_id", this.username);

        DBObject updateObj = new BasicDBObject("password", password);

        collection.update(query, updateObj);
    }

    @Override
    public Object getFollowing(){
        return collection.findOne(this.username).get("followers");
    }

    @Override
    public void appendFollowing(String username){
        DBObject query = new BasicDBObject("_id", this.username);

        DBObject updateObj = new BasicDBObject("followers", username);

        collection.update(query, new BasicDBObject("$push", updateObj));
    }

    @Override
    public Object getRequests(){
        return collection.findOne(this.username).get("requests");
    }

    @Override
    public void appendRequests(String username){
        DBObject query = new BasicDBObject("_id", this.username);

        DBObject updateObj = new BasicDBObject("requests", username);

        collection.update(query, new BasicDBObject("$push", updateObj));
    }





}
