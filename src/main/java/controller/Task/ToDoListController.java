package controller.Task;

import boundary.User.loadUserScheduleInputBoundary;
import database.MongoDBAccess;
import entity.Task.CommonTask;
import javafx.scene.control.TableView;
import main.collectCollection;
import screens.ToDoScreen;
import useCaseInteractor.DataAccess;
import useCaseInteractor.User.loadUserSchedule;
import useCaseInteractor.User.userCollection;

import java.net.UnknownHostException;
import java.util.ArrayList;

public class ToDoListController {
    public ArrayList<ArrayList<Object>> getAllTasks() throws UnknownHostException {
        DataAccess dataAccess = new MongoDBAccess(collectCollection.main(), userCollection.getUsername());
        return dataAccess.getUserEntireTask();
    }
}
