import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import entity.Task.Task;
import entity.Task.TaskFactory;
import org.junit.jupiter.api.BeforeAll;
import requestModel.EventItemRequestModel;
import requestModel.ImportRequestModel;
import requestModel.TaskRequestModel;
import responseModel.Event.EventItemResponseModel;
import responseModel.Task.TaskResponseModel;
import useCaseInteractor.DataAccess;
import useCaseInteractor.Task.UpdateTask;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class UpdateTaskTest {
    static DBCollection collection_example = null;
    public static class MongoDB {
        public void main(String[] args) {
            //Creating a MongoDB client
            MongoClient mongo = new MongoClient( "localhost" , 27017 );
            //Accessing the database
            MongoDatabase database = mongo.getDatabase("myDatabase");
            //Creating a collection
            collection_example = (DBCollection) database.getCollection("sampleCollection");
        }
    }

    @BeforeAll
    public static void setUp(){

    }
    DataAccess dataAccess = new DataAccess() {
        @Override
        public void createUser(String password, String fName, String lName) {

        }

        @Override
        public boolean getUserExist(String username) {
            return false;
        }

        @Override
        public boolean eventExists(EventItemRequestModel request) {
            return false;
        }

        @Override
        public void resetEvents() {

        }

        @Override
        public void resetTask() {

        }

        @Override
        public void setEvent(EventItemResponseModel responseModel) {

        }

        @Override
        public void setImportEvents(ImportRequestModel requestModel) {

        }

        @Override
        public ArrayList<ArrayList<Object>> getUserEvents() {
            return null;
        }

        @Override
        public void setTask(TaskResponseModel responseModel) {

        }

        @Override
        public ArrayList<ArrayList<Object>> getUserTasks() {
            return null;
        }

        @Override
        public void setPassword(String password) {

        }

        @Override
        public boolean checkPassword(String password) {
            return false;
        }
    };
    TaskFactory taskFactory = new TaskFactory() {
        @Override
        public Task create(String description, String date, String category) {
            return null;
        }
    };

    TaskRequestModel taskRequestModel = new TaskRequestModel("soccer", "2022-12-02", "sport");

    @org.junit.jupiter.api.Test
    void UpdateTask_test() {
        new UpdateTask(dataAccess, taskFactory).create(taskRequestModel);
        assertEquals("sport", dataAccess.getUserTasks());
    }

}
