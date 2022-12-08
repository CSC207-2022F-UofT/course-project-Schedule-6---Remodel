package database;

import com.mongodb.*;
import requestModel.EventItemRequestModel;
import responseModel.Event.EventItemResponseModel;
import responseModel.Task.TaskResponseModel;
import requestModel.ImportRequestModel;
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
    public void createUser(String password, String fName, String lName){
        ArrayList<Object> events = new ArrayList<>();
        ArrayList<Object> tasks = new ArrayList<>();
        DBObject person = new BasicDBObject("_id", this.username)
                .append("password", password).append("firstName", fName).append("lastName", lName)
                .append("events", events).append("tasks", tasks);
        collection.insert(person);
    }

    @Override
    public boolean getUserExist(String username){
        return this.collection.findOne(username) != null;
    }

    @Override
    public boolean eventExists(EventItemRequestModel request){
        ArrayList<ArrayList<Object>> events = this.getUserEvents();
        for(ArrayList<Object> event: events){
            if((event.get(0).equals(request.getTitle())) && (event.get(1).equals(request.getStartDate().toString())) &&
                    (event.get(2).equals(request.getEndDate().toString())) && (event.get(3).equals(request.getStartTime().toString())) &&
                    (event.get(4).equals(request.getEndTime().toString()))){
                return true;
            }
        }
        return false;
    }

    @Override
    public void resetEvents(){
        DBObject query = new BasicDBObject("_id", this.username);
        ArrayList<Object> lst = new ArrayList<>();
        DBObject updateObj = new BasicDBObject("events", lst);
        this.collection.update(query, new BasicDBObject("$set", updateObj));
    }

    @Override
    public void resetTask(){
        DBObject query = new BasicDBObject("_id", this.username);
        ArrayList<Object> lst = new ArrayList<>();
        DBObject updateObj = new BasicDBObject("tasks", lst);
        this.collection.update(query, new BasicDBObject("$set", updateObj));
    }

    @Override
    public void setEvent(EventItemResponseModel responseModel) {
        DBObject query = new BasicDBObject("_id", this.username);
        ArrayList<Object> lst = new ArrayList<>();
        lst.add(responseModel.getTitle());
        lst.add(responseModel.getStartDate().toString());
        lst.add(responseModel.getEndDate().toString());
        lst.add(responseModel.getStartTime().toString());
        lst.add(responseModel.getEndTime().toString());
        DBObject updateObj = new BasicDBObject("events", lst);
        this.collection.update(query, new BasicDBObject("$push", updateObj));
    }

    @Override
    public void setImportEvents(ImportRequestModel requestModel) {
        DBObject query = new BasicDBObject("_id", this.username);
        ArrayList<Object> lst = new ArrayList<>();
        lst.add(requestModel.getTitles());
        lst.add(requestModel.getStartDates().toString());
        lst.add(requestModel.getEndDates().toString());
        lst.add(requestModel.getStartTime().toString());
        lst.add(requestModel.getEndTime().toString());
        DBObject updateObj = new BasicDBObject("events", lst);
        this.collection.update(query, new BasicDBObject("$push", updateObj));
    }

    @Override
    public ArrayList<Object> getSingleEvent(EventItemResponseModel responseModel) {
        ArrayList<Object> lst = new ArrayList<>();
        lst.add(responseModel.getTitle());
        lst.add(responseModel.getStartDate());
        lst.add(responseModel.getEndDate());
        lst.add(responseModel.getStartTime());
        lst.add(responseModel.getEndTime());

        ArrayList<ArrayList<Object>> allEvents = this.getUserEvents();

        for (ArrayList<Object> objects : allEvents) {
            if (objects.equals(lst)) {
                return objects;
            }
        }
        return lst;
    }

    @Override
    public ArrayList<ArrayList<Object>> getUserEvents() {
        DBObject document = collection.findOne(this.username);
        BasicDBList list = (BasicDBList) document.get("events");
        ArrayList<ArrayList<Object>> entireList = new ArrayList<>();
        for (Object sublist: list) {
            entireList.add((ArrayList<Object>) sublist);
        }
        return entireList;
    }

    @Override
    public void deleteEventItem(EventItemResponseModel responseModel) {
        DBObject query = new BasicDBObject("_id", this.username);

        ArrayList<Object> lst = new ArrayList<>();
        lst.add(responseModel.getTitle());
        lst.add(responseModel.getStartDate());
        lst.add(responseModel.getEndDate());
        lst.add(responseModel.getStartTime());
        lst.add(responseModel.getEndTime());

        ArrayList<ArrayList<Object>> allEvents = this.getUserEvents();

        for (ArrayList<Object> objects : allEvents) {
            if (objects.equals(lst)) {
                allEvents.remove(objects);
                DBObject updateObj = new BasicDBObject("events", allEvents);
                collection.update(query, new BasicDBObject("$set", updateObj));
            }
        }
    }

    @Override
    public void setTask(TaskResponseModel responseModel) {
        DBObject query = new BasicDBObject("_id", this.username);
        ArrayList<Object> lst = new ArrayList<>();
        lst.add(responseModel.getDescription());
        lst.add(responseModel.getDate().toString());
        lst.add(responseModel.getCategory());
        DBObject updateObj = new BasicDBObject("tasks", lst);
        this.collection.update(query, new BasicDBObject("$push", updateObj));
    }

    @Override
    public ArrayList<Object> getSingleTask(TaskResponseModel responseModel) {
        ArrayList<Object> lst = new ArrayList<>();
        lst.add(responseModel.getDescription());
        lst.add(responseModel.getDate().toString());
        lst.add(responseModel.getCategory());

        ArrayList<ArrayList<Object>> entireTask = this.getUserTasks();

        for (ArrayList<Object> objects : entireTask) {
            if (objects.equals(lst)) {
                return objects;
            }
        }
        return lst;
    }

    @Override
    public ArrayList<ArrayList<Object>> getUserTasks() {
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
        lst.add(responseModel.getDate().toString());
        lst.add(responseModel.getCategory());

        ArrayList<ArrayList<Object>> entireTask = this.getUserTasks();

        for (ArrayList<Object> objects : entireTask) {
            if (objects.equals(lst)) {
                entireTask.remove(objects);
                DBObject updateObj = new BasicDBObject("tasks", entireTask);
                collection.update(query, new BasicDBObject("$set", updateObj));
            }
        }
    }
    @Override
    public boolean getTaskExist(TaskResponseModel responseModel) {
        ArrayList<ArrayList<Object>> entireTask = this.getUserTasks();

        ArrayList<Object> lst = new ArrayList<>();
        lst.add(responseModel.getDescription());
        lst.add(responseModel.getDate().toString());
        lst.add(responseModel.getCategory());
        for (ArrayList<Object> objects : entireTask) {
            if (objects.equals(lst)){
                //return true if task exists
                return true;
            }
        }
        //return false if task does not exist
        return false;
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

    @Override
    public boolean checkPassword(String password){
        return collection.findOne(this.username).get("password").equals(password);
    }
}

