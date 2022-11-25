package database;//package database;

import com.mongodb.*;
import javafx.scene.control.TextField;

import java.net.UnknownHostException;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class MongoTesting {
    public static void main(String[] args) throws UnknownHostException {

        //My local database
//        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));

        //My remote database
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://stevenli:stevenli@cluster0.koruj0t.mongodb.net/?retryWrites=true&w=majority"));

        //Brians remote database
//        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://123:123@cluster1.d3e1rhp.mongodb.net/?retryWrites=true&w=majority"));


        DB database = mongoClient.getDB("schedule6-testingdb");

        DBCollection collection = database.getCollection("schedule6-testingcollection");

        DBObject person = new BasicDBObject("_id", "Steven1234")
                .append("name", "Bob the Builder");

        collection.insert(person);
    }
}

