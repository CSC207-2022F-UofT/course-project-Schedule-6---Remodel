package main;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import java.net.UnknownHostException;

public class collectCollection {
    public static DBCollection main() throws UnknownHostException {

        MongoClient mongoClient = new MongoClient(new MongoClientURI(
                "mongodb+srv://project6:project6@cluster0.koruj0t.mongodb.net/?retryWrites=true&w=majority"));
        DB database = mongoClient.getDB("schedule6-testingdb");
        DBCollection collection = database.getCollection("schedule6-testingcollection");

        return collection;

    }
}
