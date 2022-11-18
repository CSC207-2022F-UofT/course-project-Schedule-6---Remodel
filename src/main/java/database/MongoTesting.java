package database;//package database;
//
//import com.mongodb.*;
//
//import java.util.Arrays;
//import java.util.List;
//
//public class MongoTesting {
//    public static void main(String[] args) {
//
//        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://stevenli:stevenli@cluster0.koruj0t.mongodb.net/?retryWrites=true&w=majority"));
//
//        DB database = mongoClient.getDB("testing");
//
//        DBCollection collection = database.getCollection("testingcollection");
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
//    }
//}
//
