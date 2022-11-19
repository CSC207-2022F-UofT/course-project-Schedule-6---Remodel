package database;//package database;

//import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public class MongoTesting {
    public static void main(String[] args) throws UnknownHostException {

        MongoClient mongoClient = MongoClients.create("mongodb://stevenli:stevenli@cluster0.koruj0t.mongodb.net/?retryWrites=true&w=majority");

        MongoDatabase db = mongoClient.getDatabase("sampleDB");

        MongoCollection collection = db.getCollection("sampleCollection");

        Document sampledoc = new Document("_id", "1").append("name", "john smith");

        collection.insertOne(sampledoc);


        //My local database
//        MongoClient mongoClient = new MongoClient("mongodb://localhost:27017");

        //My remote database
//        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://stevenli:stevenli@cluster0.koruj0t.mongodb.net/?retryWrites=true&w=majority"));

        //other database
//        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://123:123@cluster1.d3e1rhp.mongodb.net/?retryWrites=true&w=majority"));


//        DB database = mongoClient.getDB("schedule6-testingdb");
//
//        DBCollection collection = database.getCollection("schedule6-testingcollection");
//
//        List<Integer> books = Arrays.asList(27464, 747854);
//        DBObject person = new BasicDBObject("_id", "jo")
//                .append("name", "Tony Stark")
//                .append("address", new BasicDBObject("street", "123 Fake St")
//                        .append("city", "Faketon")
//                        .append("state", "MA")
//                        .append("zip", 12345))
//                .append("books", books);
//
//        collection.insert(person);
    }
}

