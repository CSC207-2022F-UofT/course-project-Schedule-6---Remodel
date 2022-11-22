import boundary.AddScheduleItemInputBoundary;
import com.mongodb.*;
import controller.AddScheduleController;
import entity.CommonScheduleItemFactory;
import entity.ScheduleItemFactory;
import entity.User;
import presenter.WeeklyInfoPresenter;
import useCaseInteractor.DataAccess;
import useCaseInteractor.Schedule.AddScheduleItem;

import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException {

        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://stevenli:stevenli@cluster0.koruj0t.mongodb.net/?retryWrites=true&w=majority"));
        DB database = mongoClient.getDB("schedule6-testingdb");
        DBCollection collection = database.getCollection("schedule6-testingcollection");

        DataAccess dataAccess = null;
        WeeklyInfoPresenter presenter = null;
        ScheduleItemFactory scheduleItemFactory = new CommonScheduleItemFactory();
        AddScheduleItemInputBoundary interactor = new AddScheduleItem(dataAccess, scheduleItemFactory, presenter);
        AddScheduleController addScheduleController = new AddScheduleController(interactor);


        DBObject person = new BasicDBObject("_id", "Nizar123")
                .append("name", "Bob not the Builder");

        collection.insert(person);
    }
}
