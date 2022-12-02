package database;

import com.mongodb.*;
import responseModel.Schedule.ScheduleItemResponseModel;
import responseModel.Task.TaskResponseModel;
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
    public boolean createUser(String password, String fName, String lName){
        if(this.getUserExist()){
            return false;
        }
        ArrayList<Object> schedules = new ArrayList<>();
        ArrayList<Object> tasks = new ArrayList<>();
        ArrayList<Object> followers = new ArrayList<>();
        ArrayList<Object> requests = new ArrayList<>();
        DBObject person = new BasicDBObject("_id", this.username)
                .append("password", password).append("firstName", fName).append("lastName", lName)
                .append("schedules", schedules).append("tasks", tasks)
                .append("followers", followers)
                .append("requests", requests);
        collection.insert(person);
        return true;
    }

    @Override
    public void setSchedule(ScheduleItemResponseModel responseModel) {
        DBObject query = new BasicDBObject("_id", this.username);
        ArrayList<Object> lst = new ArrayList<>();
        lst.add(responseModel.getTitle());
        lst.add(responseModel.getStartDate());
        lst.add(responseModel.getEndDate());
        lst.add(responseModel.getStartTime());
        lst.add(responseModel.getEndTime());
        DBObject updateObj = new BasicDBObject("schedules", lst);
        this.collection.update(query, new BasicDBObject("$push", updateObj));
    }

    @Override
    public ArrayList<Object> getSingleSchedule(ScheduleItemResponseModel responseModel) {
        ArrayList<Object> lst = new ArrayList<>();
        lst.add(responseModel.getTitle());
        lst.add(responseModel.getStartDate());
        lst.add(responseModel.getEndDate());
        lst.add(responseModel.getStartTime());
        lst.add(responseModel.getEndTime());

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
        BasicDBList list = (BasicDBList) document.get("schedules");
        ArrayList<ArrayList<Object>> entireList = new ArrayList<>();
        for (Object sublist: list) {
            entireList.add((ArrayList<Object>) sublist);
        }
        return entireList;
    }

    @Override
    public void deleteScheduleItem(ScheduleItemResponseModel responseModel) {
        DBObject query = new BasicDBObject("_id", this.username);

        ArrayList<Object> lst = new ArrayList<>();
        lst.add(responseModel.getTitle());
        lst.add(responseModel.getStartDate());
        lst.add(responseModel.getEndDate());
        lst.add(responseModel.getStartTime());
        lst.add(responseModel.getEndTime());

        ArrayList<ArrayList<Object>> entireSchedule = this.getUserEntireSchedule();

        for (ArrayList<Object> objects : entireSchedule) {
            if (objects.equals(lst)) {
                entireSchedule.remove(objects);
                DBObject updateObj = new BasicDBObject("schedules", entireSchedule);
                collection.update(query, new BasicDBObject("$set", updateObj));
            }
        }
    }

    @Override
    public void setTask(TaskResponseModel responseModel) {
        DBObject query = new BasicDBObject("_id", this.username);
        ArrayList<Object> lst = new ArrayList<>();
        lst.add(responseModel.getDescription());
        lst.add(responseModel.getDate());
        lst.add(responseModel.getCategory());
        DBObject updateObj = new BasicDBObject("tasks", lst);
        this.collection.update(query, new BasicDBObject("$push", updateObj));
    }

    @Override
    public ArrayList<Object> getSingleTask(TaskResponseModel responseModel) {
        ArrayList<Object> lst = new ArrayList<>();
        lst.add(responseModel.getDescription());
        lst.add(responseModel.getDate());
        lst.add(responseModel.getCategory());

        ArrayList<ArrayList<Object>> entireTask = this.getUserEntireTask();

        for (ArrayList<Object> objects : entireTask) {
            if (objects.equals(lst)) {
                return objects;
            }
        }
        return lst;
    }

    @Override
    public ArrayList<ArrayList<Object>> getUserEntireTask() {
        DBObject document = collection.findOne(this.username);
        BasicDBList list = (BasicDBList) document.get("tasks");
        ArrayList<ArrayList<Object>> entireList = new ArrayList<>();
        for (Object sublist: list) {
            entireList.add((ArrayList<Object>) sublist);
        }
        return entireList;
    }

    @Override
    public void deleteTask(TaskResponseModel responseModel) {
        DBObject query = new BasicDBObject("_id", this.username);

        ArrayList<Object> lst = new ArrayList<>();
        lst.add(responseModel.getDescription());
        lst.add(responseModel.getDate());
        lst.add(responseModel.getCategory());

        ArrayList<ArrayList<Object>> entireTask = this.getUserEntireTask();

        for (ArrayList<Object> objects : entireTask) {
            if (objects.equals(lst)) {
                entireTask.remove(objects);
                DBObject updateObj = new BasicDBObject("tasks", entireTask);
                collection.update(query, new BasicDBObject("$set", updateObj));
            }
        }
    }

    @Override
    public boolean getUserExist(String username){
        return this.collection.findOne(username) != null;
    }


    @Override
    public boolean getUserExist(){ return this.collection.findOne(this.username) != null;}

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

    @Override
    public boolean checkPassword(String password){
        return collection.findOne(this.username).get("password").equals(password);
    }

    @Override
    public void setFollowing(ArrayList<String> following){
        DBObject query = new BasicDBObject("_id", this.username);

        DBObject updateObj = new BasicDBObject("followers", this.username);

        this.collection.update(query, updateObj);
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
    @Override
    public void setRequests(ArrayList<String> usernames){
        DBObject query = new BasicDBObject("_id", this.username);

        DBObject updateObj = new BasicDBObject("requests", this.username);

        this.collection.update(query, updateObj);
    }
}
