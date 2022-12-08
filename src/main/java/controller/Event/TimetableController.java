package controller.Event;

import boundary.Event.LoadEventsInputBoundary;
import boundary.Event.UpdateEventInputBoundary;
import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.model.Entry;
import com.calendarfx.view.CalendarView;
import controller.User.userCollection;
import database.MongoDBAccess;
import entity.Event.CommonEventItemFactory;
import entity.Event.EventItemFactory;
import entity.Event.TimeManagement;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import main.collectCollection;
import presenter.EventsPresenter;
import requestModel.EventItemRequestModel;
import screens.CreateNewEntryScreen;
import useCaseInteractor.DataAccess;
import useCaseInteractor.Event.UpdateEventItem;
import useCaseInteractor.Event.loadEventsUseCase;

import java.io.IOException;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimetableController {
    public static CalendarView calendar = new CalendarView();

    private final EventsPresenter eventsPresenter = new EventsPresenter();

    private final TimeManagement TM = new TimeManagement();

    public void loginLoadEvents() throws UnknownHostException {
        DataAccess database = new MongoDBAccess(collectCollection.main(), userCollection.getUsername());
        LoadEventsInputBoundary event = new loadEventsUseCase(database, eventsPresenter);
        event.loadEvents();
    }

    public void saveCalendarEntries(Label entriesSaved) throws UnknownHostException {
        DataAccess dataAccess = new MongoDBAccess(collectCollection.main(), userCollection.getUsername()); // should not be here
        CalendarView calendar = TimetableController.calendar; // should not be here

        ArrayList<String> listEntries = new ArrayList<>();
        Map<LocalDate, List<Entry<?>>> map = new HashMap<>();
        for (Calendar userCalender : calendar.getCalendars()) {
            map = userCalender.findEntries(TM.getStartDate(), TM.getEndDate(), TM.getTimeZone());
        }
        for (Object entry : map.values()) {
            String singleDayData = entry.toString();
            while (singleDayData.contains("],")) {
                String substring = singleDayData.substring(0, singleDayData.indexOf("],") + 3);
                singleDayData = singleDayData.substring(singleDayData.indexOf("],") + 3);
                listEntries.add(substring);
            }
            listEntries.add(singleDayData);
        }

        dataAccess.resetEvents(); // should not be here

        for (String s : listEntries) {
            saveEntrytoDB(s);
        }
        eventsPresenter.saveEntriesMessage(entriesSaved);
    }

    public void saveEntrytoDB(Object entry) throws UnknownHostException {
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

        // adds entry to database
        // breaks CA
        DataAccess dataAccess = new MongoDBAccess(collectCollection.main(), userCollection.getUsername());
        EventItemFactory item = new CommonEventItemFactory();
        UpdateEventInputBoundary newEvent = new UpdateEventItem(dataAccess, item);
        EventItemRequestModel request = new EventItemRequestModel(title, LocalDate.of(Integer.parseInt(newStartDate[0]),
                Integer.parseInt(newStartDate[1]), Integer.parseInt(newStartDate[2])), LocalDate.of(Integer.parseInt(newEndDate[0]),
                Integer.parseInt(newEndDate[1]), Integer.parseInt(newEndDate[2])),
                LocalTime.of(Integer.parseInt(newStartTime[0]), Integer.parseInt(newStartTime[1])), LocalTime.of(Integer.parseInt(newEndTime[0]), Integer.parseInt(newEndTime[1])));
        if (!dataAccess.eventExists(request)) { // eventExists should not be here as well
            newEvent.create(request);
        }
    }


    //adds "Add Future Events" onto calendar
    public void addEventAction(TextField eventTitle, DatePicker startDate,
                               DatePicker endDate, TextField startTime, TextField endTime, Label errorMessage) {
        CalendarView calendar = TimetableController.calendar; // should not be here

        try {
            boolean add = true;
            if (eventTitle.getText().isBlank() || (startDate == null) || (endDate == null) ||
                    startTime.getText().isBlank() || endTime.getText().isBlank()) {
                errorMessage.setText("PLEASE FILL IN ALL FIELDS");
                textFade(2850, errorMessage);
                add = false;
            }
            if (!inputTimeChecker(startTime.getText(), endTime.getText())) {
                errorMessage.setText("PLEASE FILL A VALID TIME AS HH:MM");
                textFade(3950, errorMessage);
                add = false;
            }
            String[] arrayTime = (startTime.getText() + ":" + endTime.getText()).split(":");
            LocalTime localStartTime = LocalTime.of(Integer.parseInt(arrayTime[0]), Integer.parseInt(arrayTime[1]));
            LocalTime localEndTime = LocalTime.of(Integer.parseInt(arrayTime[2]), Integer.parseInt(arrayTime[3]));
            if (localStartTime.isAfter(localEndTime) || localEndTime.isBefore(localStartTime)) {
                errorMessage.setText("START TIME CAN'T BE AFTER THE END TIME");
                textFade(3950, errorMessage);
                add = false;
            }
            if (startDate.getValue().isAfter(endDate.getValue()) || endDate.getValue().isBefore(startDate.getValue())) {
                errorMessage.setText("START DATE CAN'T BE AFTER THE END DATE");
                textFade(3950, errorMessage);
                add = false;
            }
            if (add) {
                //Makes the event with the name eventTitle
                Entry entry = new Entry(eventTitle.getText());
                //sets the days and time for the entry.
                entry.setInterval(startDate.getValue(), localStartTime, endDate.getValue(), localEndTime);
                for (Calendar temp : calendar.getCalendars()) {
                    temp.addEntry(entry);
                }
                Stage stage = (Stage) eventTitle.getScene().getWindow();
                stage.close();
            }
        } catch (Exception ignored) {
        }
    }

    public void textFade(int number, Label errorMessage) {
        FadeTransition FTNotValidTime = new FadeTransition(Duration.millis(number), errorMessage);
        FTNotValidTime.setFromValue(1.0);
        FTNotValidTime.setToValue(0.0);
        FTNotValidTime.setAutoReverse(true);
        FTNotValidTime.play();
    }

    public boolean inputTimeChecker(String startTime, String endTime) {
        String[] time = (startTime + ":" + endTime).split(":");
        return (startTime.matches("\\d{2}:\\d{2}")) &&
                (endTime.matches("\\d{2}:\\d{2}")) &&
                (Integer.parseInt(time[0]) <= 24) && (Integer.parseInt(time[0]) > 0) &&
                (Integer.parseInt(time[2]) <= 24) && (Integer.parseInt(time[2]) > 0) &&
                (Integer.parseInt(time[1]) <= 59) && (Integer.parseInt(time[3]) <= 59);
    }

    public void setUsernameChangeLabel(String name) {
        for (Calendar temp : calendar.getCalendars()) {
            temp.setName(name);
        }
    }

    public void futureEventButton() {
        CreateNewEntryScreen.newForm();
    }

    public void loadCalendar(GridPane Gridlock) {
        CalendarSource myCalendarSource = new CalendarSource("");
        calendar.getCalendarSources().addAll(myCalendarSource);
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

    public void loadTODO(GridPane TODO) throws IOException {
        eventsPresenter.loadTODO(TODO);
    }

    public void cancelEventAction(Button cancelButton) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}