package database;//package database;

import com.mongodb.*;
import javafx.scene.control.TextField;

import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MongoTesting {
    public static void main(String[] args) throws UnknownHostException {

        //My local database
//        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));

        //Stevens remote database
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://stevenli:stevenli@cluster0.koruj0t.mongodb.net/?retryWrites=true&w=majority"));

        //Brians remote database
//        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://123:123@cluster1.d3e1rhp.mongodb.net/?retryWrites=true&w=majority"));


        DB database = mongoClient.getDB("schedule6-testingdb");
        DBCollection collection = database.getCollection("schedule6-testingcollection");

        ArrayList<Object> list = new ArrayList<>();
        ArrayList<Object> sublist_1 = new ArrayList<>();
        sublist_1.add("Meeting");
        sublist_1.add(LocalDate.of(2022, 11, 26));
        sublist_1.add(LocalTime.of(12, 15));
        sublist_1.add(LocalTime.of(2, 30));
        ArrayList<Object> sublist_2 = new ArrayList<>();
        sublist_2.add("Workout");
        sublist_2.add(LocalDate.of(2022, 11, 26));
        sublist_2.add(LocalTime.of(2, 15));
        sublist_2.add(LocalTime.of(3, 30));
        list.add(sublist_2);
        list.add(sublist_1);
//        DBObject person = new BasicDBObject("_id", "test_user123")
//                .append("schedule", list);
//        collection.insert(person);

        DBObject query = new BasicDBObject("_id", "test_user123");

        // Adding to DB
        list.remove(sublist_1);
        DBObject updateObj = new BasicDBObject("schedule", list);
        collection.update(query, new BasicDBObject("$set", updateObj));

        // Getting from DB
//        DBObject document = collection.findOne(query);
//        BasicDBList list = (BasicDBList) document.get("schedule");
//
//        ArrayList<ArrayList<Object>> res = new ArrayList<>();
//
//        for (Object sublist: list) {
//            res.add((ArrayList<Object>) sublist);
//        }
//
//        System.out.println(res.size());
    }
}

