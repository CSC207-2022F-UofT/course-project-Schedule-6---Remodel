package controller.Task;

import database.MongoDBAccess;
import main.collectCollection;
import useCaseInteractor.DataAccess;
import useCaseInteractor.User.userCollection;

import java.net.UnknownHostException;
import java.util.ArrayList;

public class TaskListController {
    public ArrayList<ArrayList<Object>> getAllTasks() throws UnknownHostException {
        DataAccess dataAccess = new MongoDBAccess(collectCollection.main(), userCollection.getUsername());
        return dataAccess.getUserEntireTask();
    }
}