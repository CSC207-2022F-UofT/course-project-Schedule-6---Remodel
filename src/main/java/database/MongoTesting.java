package database;//package database;

import com.mongodb.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.net.UnknownHostException;
import java.util.ArrayList;
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
//        ArrayList<String> list = new ArrayList<>();
//        list.add("Apple");
//        list.add("Orange");
//        list.add("Banana");
//        DBObject person = new BasicDBObject("_id", "steven123")
//                .append("name", list);
//
//        collection.insert(person);

        DBObject query = new BasicDBObject("_id", "steven123");

        DBObject updateObj = new BasicDBObject("name", "waffles");

        collection.update(query, new BasicDBObject("$push", updateObj));
    }
}



