package database;

import com.mongodb.*;
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
        lst.add(requestModel.getTitle());
        lst.add(requestModel.getDate());
        lst.add(requestModel.getStartTime());
        lst.add(requestModel.getEndTime());
        DBObject updateObj = new BasicDBObject("schedule", lst);
        this.collection.update(query, new BasicDBObject("$push", updateObj));
    }


    // Still unsure about this method, depends on how editing schedule will be implemented
    @Override
    public ArrayList<Object> getSingleSchedule(ScheduleItemRequestModel requestModel) {
        ArrayList<Object> lst = new ArrayList<>();
        lst.add(requestModel.getTitle());
        lst.add(requestModel.getDate());
        lst.add(requestModel.getStartTime());
        lst.add(requestModel.getEndTime());

        ArrayList<ArrayList<Object>> entireSchedule = this.getUserEntireSchedule();

        for (ArrayList<Object> objects : entireSchedule) {
            if (objects.equals(lst)) {
                return objects;
            }
        }
        return lst;
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
    public void deleteScheduleItem(ScheduleItemRequestModel requestModel) {
        DBObject query = new BasicDBObject("_id", this.username);

        ArrayList<Object> lst = new ArrayList<>();
        lst.add(requestModel.getTitle());
        lst.add(requestModel.getDate());
        lst.add(requestModel.getStartTime());
        lst.add(requestModel.getEndTime());

        ArrayList<ArrayList<Object>> entireSchedule = this.getUserEntireSchedule();

        for (ArrayList<Object> objects : entireSchedule) {
            if (objects.equals(lst)) {
                entireSchedule.remove(objects);
                DBObject updateObj = new BasicDBObject("schedule", entireSchedule);
                collection.update(query, new BasicDBObject("$set", updateObj));
            }
        }
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

    //returns all user data
    @Override
    public DBObject getUserData(){
        return collection.findOne(this.username);
    }

    //reset/setting password
    @Override
    public void setPassword(String password){
        DBObject query = new BasicDBObject("_id", this.username);

        DBObject updateObj = new BasicDBObject("password", password);

        collection.update(query, updateObj);
    }

    //returns following list
    @Override
    public Object getFollowing(){
        return collection.findOne(this.username).get("followers");
    }

    //add follower to following list
    @Override
    public void appendFollowing(String username){
        DBObject query = new BasicDBObject("_id", this.username);

        DBObject updateObj = new BasicDBObject("followers", username);

        collection.update(query, new BasicDBObject("$push", updateObj));
    }

    //returns current request, you can accept or decline a request
    @Override
    public Object getRequests(){
        return collection.findOne(this.username).get("requests");
    }

    //adds a request to list of requests.
    @Override
    public void appendRequests(String username){
        DBObject query = new BasicDBObject("_id", this.username);

        DBObject updateObj = new BasicDBObject("requests", username);

        collection.update(query, new BasicDBObject("$push", updateObj));
    }

    //sets a new request list when a request is accepted or declined
    public void setRequests(ArrayList<String> usernames){
        DBObject query = new BasicDBObject("_id", this.username);

        DBObject updateObj = new BasicDBObject("requests", username);

        collection.update(query, updateObj);
    }





}
