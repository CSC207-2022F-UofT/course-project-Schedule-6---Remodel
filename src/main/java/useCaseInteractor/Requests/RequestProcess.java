package useCaseInteractor.Requests;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import database.MongoDBAccess;
import entity.Request;
import useCaseInteractor.User.userCollection;

import java.net.UnknownHostException;
import java.util.ArrayList;

public class RequestProcess implements Request {

    private String from;
    private int move; // 0 for accepting request, 1 to decline request

    public RequestProcess(String from, int move){
        this.from = from;
    }

    //Accepts users by making them follow each other
    public void accept(DBCollection collection){
        MongoDBAccess client = new MongoDBAccess(collection, userCollection.getUsername());

        client.appendFollowing(this.from);

        MongoDBAccess client2 = new MongoDBAccess(collection, this.from);

        client2.appendFollowing(userCollection.getUsername());

    }

    //Declines the request by removing out of the db
    public void decline(DBCollection collection){
        MongoDBAccess client = new MongoDBAccess(collection, this.from);
        ArrayList<String> currRequests = (ArrayList<String>) client.getRequests();
        currRequests.remove(this.from);
        client.setRequests(currRequests);
    }

    //Creates client and collects collection.
    public void main(String[] args) throws UnknownHostException {
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://stevenli:stevenli@cluster0.koruj0t.mongodb.net/?retryWrites=true&w=majority"));

        //Brians remote database
//        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://123:123@cluster1.d3e1rhp.mongodb.net/?retryWrites=true&w=majority"));


        DB database = mongoClient.getDB("schedule6-testingdb");
        DBCollection collection = database.getCollection("schedule6-testingcollection");
        if(this.move == 0){
            this.accept(collection);
        }
        else{
            this.decline(collection);
        }

    }
}
