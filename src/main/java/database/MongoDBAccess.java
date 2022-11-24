package database;

import com.mongodb.Mongo;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoClient;
import requestModel.ScheduleItemRequestModel;
import useCaseInteractor.DataAccess;

import java.net.UnknownHostException;

public class MongoDBAccess implements DataAccess {

    private final MongoClient mongoClient;

    public MongoDBAccess(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @Override
    public void savetoDB(ScheduleItemRequestModel requestModel) {
        // needs to find the user to save to

    }

    @Override
    public void pullfromDB() {

    }
}
