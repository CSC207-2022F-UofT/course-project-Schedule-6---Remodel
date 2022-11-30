package main;

import boundary.Schedule.AddScheduleItemInputBoundary;
import com.mongodb.*;
import controller.Schedule.AddScheduleController;
import entity.Schedule.CommonScheduleItemFactory;
import entity.Schedule.ScheduleItemFactory;
import boundary.Schedule.AddScheduleOutputBoundary;
import useCaseInteractor.DataAccess;
import useCaseInteractor.Schedule.AddScheduleItem;

import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException {

        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://stevenli:stevenli@cluster0.koruj0t.mongodb.net/?retryWrites=true&w=majority"));
        DB database = mongoClient.getDB("schedule6-testingdb");
        DBCollection collection = database.getCollection("schedule6-testingcollection");
    }
}
