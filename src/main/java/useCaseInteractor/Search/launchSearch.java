package useCaseInteractor.Search;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import entity.User.Search;
import database.MongoDBAccess;

import java.net.UnknownHostException;

public class launchSearch implements Search {

    private String username;


    public launchSearch(String username){
        this.username = username;
    }

    //sends a request if the user <username> exists
    @Override
    public boolean sendRequest(DBCollection collection) {

        MongoDBAccess client = new MongoDBAccess(collection, this.username);

        if(client.getUserExist(this.username)){
            client.appendRequests(this.username);
            return true;
        }
        return false;

    }

    //connects to DB and adds follow request
    public void main(String[] args) throws UnknownHostException {
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://stevenli:stevenli@cluster0.koruj0t.mongodb.net/?retryWrites=true&w=majority"));

        //Brians remote database
//        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://123:123@cluster1.d3e1rhp.mongodb.net/?retryWrites=true&w=majority"));


        DB database = mongoClient.getDB("schedule6-testingdb");
        DBCollection collection = database.getCollection("schedule6-testingcollection");

        System.out.println(this.sendRequest(collection));
    }




}