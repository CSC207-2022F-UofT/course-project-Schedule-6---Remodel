package presenter;

import boundary.Schedule.UpdateScheduleInputBoundary;
import com.calendarfx.model.Calendar;
import com.calendarfx.model.Entry;
import com.calendarfx.view.CalendarView;
import controller.Schedule.ScheduleController;
import database.MongoDBAccess;
import entity.Schedule.CommonScheduleItemFactory;
import entity.Schedule.ScheduleItemFactory;
import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import entity.Schedule.TimeManagement;
import main.Main;
import main.collectCollection;
import requestModel.ScheduleItemRequestModel;
import useCaseInteractor.DataAccess;
import useCaseInteractor.Schedule.UpdateScheduleItem;
import useCaseInteractor.User.userCollection;

import java.io.IOException;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;


public class SchedulePresenter {

    private final TimeManagement TM  = new TimeManagement();

    public void loadSchedule(CalendarView calendar, ArrayList<ArrayList<Object>> entireSchedule) {
        for (Calendar temp : calendar.getCalendars()) {
            temp.clear();
            for (ArrayList<Object> schedule : entireSchedule) {
                temp.addEntry(createEntry(schedule));
            }
        }
    }

    public Entry<String> createEntry(ArrayList<Object> schedule) {
        Entry<String> entry = new Entry<>((String) schedule.get(0));

        String[] startDate = ((String )schedule.get(1)).split("-");
        String[] endDate = ((String )schedule.get(2)).split("-");
        String[] startTime = ((String )schedule.get(3)).split(":");
        String[] endTime = ((String )schedule.get(4)).split(":");

        entry.setInterval(LocalDate.now());
        entry.changeStartDate(LocalDate.of(
                Integer.parseInt(startDate[0]), Integer.parseInt(startDate[1]), Integer.parseInt(startDate[2])));
        entry.changeEndDate(LocalDate.of(
                Integer.parseInt(endDate[0]), Integer.parseInt(endDate[1]), Integer.parseInt(endDate[2])));
        entry.changeStartTime(LocalTime.of(Integer.parseInt(startTime[0]),Integer.parseInt(startTime[1])));
        entry.changeEndTime(LocalTime.of(Integer.parseInt(endTime[0]),Integer.parseInt(endTime[1])));
        return entry;
    }
    public void printCalendarEntries(Label entriesSaved) throws UnknownHostException {
        CalendarView calendar = ScheduleController.calendar;
        Set<String> newSet = null;
        Map<LocalDate, List<Entry<?>>> map = new HashMap<>();
        DataAccess dataAccess = new MongoDBAccess(collectCollection.main(), userCollection.getUsername());
        for (Calendar temp : calendar.getCalendars()) {
            map = temp.findEntries(TM.getStartDate(), TM.getEndDate(), TM.getTimeZone());
        }
        newSet = new HashSet<>();
        for (Object entry : map.values()) {
            String singleDayData = entry.toString();
            while (singleDayData.contains("],")) {
                String substring = singleDayData.substring(0, singleDayData.indexOf("],") + 3);
                singleDayData = singleDayData.substring(singleDayData.indexOf("],") + 3);
                newSet.add(substring);
            }
            newSet.add(singleDayData);
        }

        dataAccess.resetSchedule();
        for (String s : newSet) {
            findEntryData(s);
        }
        entriesSaved.setText("ALL ENTIRES SAVED");
        FadeTransition ft = new FadeTransition(Duration.millis(1850), entriesSaved);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setAutoReverse(true);
        ft.play();
        }


    public void findEntryData(Object entry) throws UnknownHostException {
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
            String[] newStartDate = startDate.split("-");
            String[] newEndDate = endDate.split("-");
            String[] newStartTime = startTime.split(":");
            String[] newEndTime = endTime.split(":");
            ScheduleItemFactory item = new CommonScheduleItemFactory();
            DataAccess dataAccess = new MongoDBAccess(collectCollection.main(), userCollection.getUsername());
            UpdateScheduleInputBoundary addSchedule = new UpdateScheduleItem(dataAccess, item);
            ScheduleItemRequestModel request = new ScheduleItemRequestModel(title, LocalDate.of(Integer.parseInt(newStartDate[0]),
                    Integer.parseInt(newStartDate[1]),Integer.parseInt(newStartDate[2])), LocalDate.of(Integer.parseInt(newEndDate[0]),
                    Integer.parseInt(newEndDate[1]),Integer.parseInt(newEndDate[2])),
                    LocalTime.of(Integer.parseInt(newStartTime[0]),Integer.parseInt(newStartTime[1])), LocalTime.of(Integer.parseInt(newEndTime[0]),Integer.parseInt(newEndTime[1])));
            if(!dataAccess.scheduleExists(request)) {
                addSchedule.create(request);
            }
    }

    public void addScheduleAction(TextField scheduleTitle, DatePicker startDate, DatePicker endDate,
                                  TextField startTime, TextField endTime, Label errorMessage) {
        CalendarView calendar = ScheduleController.calendar;
        try {
            if (!inputTimeChecker(startTime.getText(), endTime.getText())) {
                errorMessage.setText("Please Fill a Valid Time as HH:MM".toUpperCase());
                FadeTransition FTNotValidTime = new FadeTransition(Duration.millis(3950), errorMessage);
                FTNotValidTime.setFromValue(1.0);
                FTNotValidTime.setToValue(0.0);
                FTNotValidTime.setAutoReverse(true);
                FTNotValidTime.play();
            }
            else if (isNotBlank(scheduleTitle, startDate, endDate, startTime, endTime)) {
                errorMessage.setText("Please Fill in All Fields".toUpperCase());
                FadeTransition FTBlank = new FadeTransition(Duration.millis(2850), errorMessage);
                FTBlank.setFromValue(1.0);
                FTBlank.setToValue(0.0);
                FTBlank.setAutoReverse(true);
                FTBlank.play();
            }
            else if (startDate.getValue().isAfter(endDate.getValue()) || endDate.getValue().isBefore(startDate.getValue())) {
                errorMessage.setText("Start date can't be after the end date".toUpperCase());
                FadeTransition FTNotValidDate = new FadeTransition(Duration.millis(3950), errorMessage);
                FTNotValidDate.setFromValue(1.0);
                FTNotValidDate.setToValue(0.0);
                FTNotValidDate.setAutoReverse(true);
                FTNotValidDate.play();
            }
            //Makes the event with the name scheduleTitle
            else {
                String[] arrayStartTime = startTime.getText().split(":");
                String[] arrayEndTime = endTime.getText().split(":");
                LocalTime LTS = LocalTime.of(Integer.parseInt(arrayStartTime[0]), Integer.parseInt(arrayStartTime[1]));
                LocalTime LTE = LocalTime.of(Integer.parseInt(arrayEndTime[0]), Integer.parseInt(arrayEndTime[1]));

                if (LTS.isAfter(LTE) || LTE.isBefore(LTS)){
                    errorMessage.setText("Start time can't be after the end time".toUpperCase());
                    FadeTransition FTNotValidTime = new FadeTransition(Duration.millis(3950), errorMessage);
                    FTNotValidTime.setFromValue(1.0);
                    FTNotValidTime.setToValue(0.0);
                    FTNotValidTime.setAutoReverse(true);
                    FTNotValidTime.play();
                }
                else{
                    Entry entry = new Entry(scheduleTitle.getText());
                    //sets the days and time for the entry.
                    entry.setInterval(startDate.getValue(), LTS, endDate.getValue(), LTE);
                    for (Calendar temp : calendar.getCalendars()) {
                        temp.addEntry(entry);
                    }
                    Stage stage = (Stage) scheduleTitle.getScene().getWindow();
                    stage.close();
                }

            }
        } catch (Exception e) {}
    }

    public boolean inputTimeChecker(String startTime, String endTime) {
        String[] time = (startTime + ":" + endTime).split(":");
        return (startTime.matches("\\d{2}:\\d{2}") || startTime.matches("\\d:\\d{2}")) &&
                (endTime.matches("\\d{2}:\\d{2}") || endTime.matches("\\d:\\d{2}")) &&
                (Integer.parseInt(time[0]) <= 12) && (Integer.parseInt(time[0]) > 0) &&
                (Integer.parseInt(time[2]) <= 12) && (Integer.parseInt(time[2]) > 0) &&
                (Integer.parseInt(time[1]) <= 59) && (Integer.parseInt(time[3]) <= 59);
    }
    public boolean isNotBlank(TextField scheduleTitle, DatePicker startDate, DatePicker endDate,
                              TextField startTime, TextField endTime) {
        if (scheduleTitle.getText() == "" || (startDate == null) || (endDate == null) ||
                startTime.getText().isBlank() || endTime.getText().isBlank()) {
            return true;
        }
        return false;
    }
    public void loadTODO(GridPane TODO) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getClassLoader().getResource("Tasks.fxml"));
        TODO.getChildren().add(fxmlLoader.load());
    }
}