package main;

import boundary.AddScheduleItemInputBoundary;
import com.mongodb.*;
import controller.AddScheduleController;
import entity.CommonScheduleItemFactory;
import entity.ScheduleItemFactory;
import entity.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.StageStyle;
import presenter.AddSchedulePresenter;
import screens.AddScheduleScreen;
import useCaseInteractor.DataAccess;
import useCaseInteractor.Schedule.AddScheduleItem;

import java.net.URL;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException {

        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://stevenli:stevenli@cluster0.koruj0t.mongodb.net/?retryWrites=true&w=majority"));
        DB database = mongoClient.getDB("schedule6-testingdb");
        DBCollection collection = database.getCollection("schedule6-testingcollection");

        DataAccess dataAccess = null;
        AddSchedulePresenter presenter = null;
        ScheduleItemFactory scheduleItemFactory = new CommonScheduleItemFactory();
        AddScheduleItemInputBoundary interactor = new AddScheduleItem(dataAccess, scheduleItemFactory, presenter);
        AddScheduleController addScheduleController = new AddScheduleController(interactor, presenter);
    }
}
