package presenter;

import boundary.Schedule.AddScheduleItemInputBoundary;
import boundary.Schedule.AddScheduleOutputBoundary;
import com.calendarfx.model.Calendar;
import com.calendarfx.view.CalendarView;
import database.MongoDBAccess;
import entity.Schedule.CommonScheduleItemFactory;
import entity.Schedule.ScheduleItem;
import entity.Schedule.TimeManagement;
import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import main.LoginPage;
import useCaseInteractor.Schedule.AddScheduleItem;
import useCaseInteractor.User.userCollection;
import main.collectCollection;
import entity.Schedule.ScheduleItemFactory;
import requestModel.ScheduleItemRequestModel;
import java.io.IOException;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class TimetablePresenter {

    private final TimeManagement TM  = new TimeManagement();


    public void printCalendarEntries(Label entriesSaved, CalendarView calendar) throws UnknownHostException {
        ArrayList<ArrayList> allEntries = new ArrayList<>();
        Map map = new HashMap();
        for (Calendar temp : calendar.getCalendars()) {
            System.out.println(temp.findEntries(TM.getStartDate(), TM.getEndDate(), TM.getTimeZone()));
            map = temp.findEntries(TM.getStartDate(), TM.getEndDate(), TM.getTimeZone());
        }
        int count = 1;
        for (Object entry : map.values()) {
            ArrayList<String> entries = new ArrayList<>();

            //Finds the title in the values of the map
            int title_start = entry.toString().toUpperCase().indexOf("TITLE=") + ("TITLE=").length();
            int title_end = entry.toString().toUpperCase().indexOf(",");
            String title = entry.toString().substring(title_start, title_end);

            //Finds the start date in the values of the map
            int startDate_start = entry.toString().toUpperCase().indexOf("STARTDATE=") + ("STARTDATE=").length();
            int startDate_end = startDate_start + 10;
            String startDate = entry.toString().substring(startDate_start, startDate_end);

            //Finds the end date in the values of the map
            int endDate_start = entry.toString().toUpperCase().indexOf("ENDDATE=") + ("ENDDATE=").length();
            int endDate_end = endDate_start + 10;
            String endDate = entry.toString().substring(endDate_start, endDate_end);

            //Finds the start time in the values of the map
            int startTime_start = entry.toString().toUpperCase().indexOf("STARTTIME=") + ("STARTTIME=").length();
            int startTime_end = startTime_start + 5;
            String startTime = entry.toString().substring(startTime_start, startTime_end);

            //Finds the end time in the values of the map
            int endTime_start = entry.toString().toUpperCase().indexOf("ENDTIME=") + ("ENDTIME=").length();
            int endTime_end = endTime_start + 5;
            String endTime = entry.toString().substring(endTime_start, endTime_end);


            System.out.println("Event " + count + ": " + title + ", " +  startDate + ", " + endDate +
                    ", " + startTime + ", " + endTime);
            count+=1;
            entries.add(title);
            entries.add(startDate);
            entries.add(endDate);
            entries.add(startTime);
            entries.add(endTime);

            allEntries.add(entries);
            }
        System.out.println(allEntries);
        MongoDBAccess dataAccess = new MongoDBAccess(collectCollection.main(), userCollection.getUsername());
        for(ArrayList entry : allEntries){
            System.out.println(entry);
            System.out.println(0);

            ScheduleItemFactory item = new CommonScheduleItemFactory();
            System.out.println(1);
            AddScheduleItemInputBoundary addSchedule = new AddScheduleItem(dataAccess, item);
            System.out.println(2);

            ScheduleItemRequestModel request = new ScheduleItemRequestModel((String) entry.get(0),(String) entry.get(1),
                    (String) entry.get(2), (String) entry.get(3),(String) entry.get(4));
            System.out.println(3);

            addSchedule.create(request);

            System.out.println(4);


        }


        entriesSaved.setText("ALL ENTIRES SAVED");
        FadeTransition ft = new FadeTransition(Duration.millis(1850), entriesSaved);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setAutoReverse(true);
        ft.play();
        }
    public void loadTODO(GridPane TODO) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginPage.class.getClassLoader().getResource("todo.fxml"));
        TODO.getChildren().add(fxmlLoader.load());
    }
}