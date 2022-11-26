package database;

import com.mongodb.*;
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
        DBObject query = new BasicDBObject("_id", this.username);
        ArrayList<Object> lst = new ArrayList<>();
        lst.add(0, requestModel.getTitle());
        lst.add(1, requestModel.getDate());
        lst.add(2, requestModel.getStartTime());
        lst.add(3, requestModel.getEndTime());
        DBObject updateObj = new BasicDBObject("schedule", lst);
        this.collection.update(query, new BasicDBObject("$push", updateObj));
    }


    // Still unsure about this method, depends on how editing schedule will be implimented
    @Override
    public ArrayList<Object> getSingleSchedule(ScheduleItemRequestModel requestModel) {
        ArrayList<Object> list = new ArrayList<>();
        list.add(0, requestModel.getTitle());
        list.add(1, requestModel.getDate());
        list.add(2, requestModel.getStartTime());
        list.add(3, requestModel.getEndTime());
        ArrayList<ArrayList<Object>> entireSchedule = this.getUserEntireSchedule();
        for (int i = 0; i < entireSchedule.size(); i++) {
            if (entireSchedule.get(i).equals(list)) {
                return entireSchedule.get(i);
            }
        }
        return list;
    }

    @Override
    public ArrayList<ArrayList<Object>>  getUserEntireSchedule() {
        DBObject document = collection.findOne(this.username);
        BasicDBList list = (BasicDBList) document.get("schedule");
        ArrayList<ArrayList<Object>> entireList = new ArrayList<>();
        for (Object sublist: list) {
            entireList.add((ArrayList<Object>) sublist);
        }
        return entireList;
    }

    @Override
    public void setTask(TaskRequestModel requestModel) {

    }

    @Override
    public ArrayList<Object> getSingleTask(TaskRequestModel requestModel) {
        return null;
    }

    @Override
    public ArrayList<ArrayList<Object>> getUserEntireTask() {
        return null;
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
