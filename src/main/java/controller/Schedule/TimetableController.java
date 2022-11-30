package controller.Schedule;

import com.calendarfx.view.CalendarView;
import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarSource;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import entity.Schedule.TimeManagement;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import database.MongoDBAccess;
import useCaseInteractor.User.userCollection;

public class TimetableController {
    public static Label usernameChangeLabel;
    private CalendarView calendar;
    private TimeManagement TM = new TimeManagement();
    public void printCalendarEntries(ActionEvent event){
        for (Calendar temp : calendar.getCalendars()) {
            System.out.println(temp.findEntries(TM.getStartDate(), TM.getEndDate(), TM.getTimeZone()));
        }
    }
    public void setUsernameChangeLabel(String name){
        for (Calendar temp: calendar.getCalendars()) {
            temp.setName(name);
        }
    }
    public void scheduleInputsButton(ActionEvent event){}
    
    public void loadCalendar(GridPane Gridlock) throws UnknownHostException {
        calendar = new CalendarView();

        MongoDBAccess client = new MongoDBAccess(this.main(), userCollection.getUsername());

        ArrayList<String> followers = (ArrayList<String>) client.getFollowing();

        ArrayList<Calendar> calendars = new ArrayList<>();

//        for(String e : followers){
//            Calendar friends = new Calendar(e);
//            friends.setStyle(Calendar.Style.STYLE7);
//            calendars.add(friends);
//        }

        //EVERYTHING BELOW IS STABLE
        //Calendar classes = new Calendar("null");
        //Calendar meetings = new Calendar("Meetings");

        //classes.setStyle(Calendar.Style.STYLE7);
        //meetings.setStyle(Calendar.Style.STYLE2);

        CalendarSource myCalendarSource = new CalendarSource("");
        myCalendarSource.getCalendars().addAll(calendars);
        calendar.getCalendarSources().addAll(myCalendarSource);
        System.out.println(calendar.getCalendarSources());
        calendar.getCalendarSources().remove(1);
        calendar.setRequestedTime(LocalTime.now());

        Thread updateTimeThread = new Thread("Calendar: Update Time Thread") {
            @Override
            public void run() {
                while (true) {
                    Platform.runLater(() -> {
                        calendar.setToday(LocalDate.now());
                        calendar.setTime(LocalTime.now());
                    });

                    try {
                        // update every 10 seconds
                        sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };

        updateTimeThread.setPriority(Thread.MIN_PRIORITY);
        updateTimeThread.setDaemon(true);
        updateTimeThread.start();
        calendar.showWeekPage();
        calendar.setShowAddCalendarButton(true);
        calendar.setShowPrintButton(false);
        calendar.setShowDeveloperConsole(false);
        calendar.setShowAddCalendarButton(false);
        Gridlock.getChildren().add(calendar);
    }


    public DBCollection main() throws UnknownHostException {
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://stevenli:stevenli@cluster0.koruj0t.mongodb.net/?retryWrites=true&w=majority"));

        //Brians remote database
//        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://123:123@cluster1.d3e1rhp.mongodb.net/?retryWrites=true&w=majority"));


        DB database = mongoClient.getDB("schedule6-testingdb");
        DBCollection collection = database.getCollection("schedule6-testingcollection");

        //this.loadCalendar(collection);
        return collection;
    }
}
