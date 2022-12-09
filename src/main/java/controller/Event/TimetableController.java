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


    /**
     * When user clicks the login button on the LoginScreen, this method will be initiated
     * Will call the laodEventsUseCase that gets data from the database and have it presented on eventsPresenter
     */
    public void loginLoadEvents() throws UnknownHostException {
        DataAccess database = new MongoDBAccess(collectCollection.main(), userCollection.getUsername());
        LoadEventsInputBoundary event = new loadEventsUseCase(database, eventsPresenter);
        event.loadEvents();
    }

    /**
     * saveCalendarEntries takes all the Event entries on the timetable, and saves all of those events
     * onto the database.
     * Called when the user clicks the Save button on the timetable
     *
     * @param entriesSaved a text label on the TimetableScreen that displays a message for the user to see
     */
    public void saveCalendarEntries(Label entriesSaved) throws UnknownHostException {
        DataAccess dataAccess = new MongoDBAccess(collectCollection.main(), userCollection.getUsername());
        CalendarView calendar = TimetableController.calendar;

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

        dataAccess.resetEvents();

        for (String s : listEntries) {
            saveEntrytoDB(s);
        }
        eventsPresenter.saveEntriesMessage(entriesSaved);
    }


    /**
     * A helper method for saveCalendarEntries. Takes in a single event entry and saves it to the database
     *
     * @param entry a single Event entry from the timetable
     */
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

        DataAccess dataAccess = new MongoDBAccess(collectCollection.main(), userCollection.getUsername());
        EventItemFactory item = new CommonEventItemFactory();
        UpdateEventInputBoundary newEvent = new UpdateEventItem(dataAccess, item);
        EventItemRequestModel request = new EventItemRequestModel(title, LocalDate.of(Integer.parseInt(newStartDate[0]),
                Integer.parseInt(newStartDate[1]), Integer.parseInt(newStartDate[2])), LocalDate.of(Integer.parseInt(newEndDate[0]),
                Integer.parseInt(newEndDate[1]), Integer.parseInt(newEndDate[2])),
                LocalTime.of(Integer.parseInt(newStartTime[0]), Integer.parseInt(newStartTime[1])), LocalTime.of(Integer.parseInt(newEndTime[0]), Integer.parseInt(newEndTime[1])));
        if (!dataAccess.eventExists(request)) {
            newEvent.create(request);
        }
    }


    //adds "Add Future Events" onto calendar

    /**
     * Called when the user clicks "Add Future Event" button on the timetable screen
     * Takes in the user inputs and checks if the inputs are valid
     * If all the inputs are valid, this method will add the new entry onto the timetable
     *
     * @param eventTitle   title of event
     * @param startDate    start date of event
     * @param endDate      end date of event
     * @param startTime    start time of event
     * @param endTime      end time of event
     * @param errorMessage text label on the screen to display messages
     */
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


    /**
     * Makes the label on the screen fade in and out
     *
     * @param number       duration of the fade
     * @param errorMessage label to be displayed
     */
    public void textFade(int number, Label errorMessage) {
        FadeTransition FTNotValidTime = new FadeTransition(Duration.millis(number), errorMessage);
        FTNotValidTime.setFromValue(1.0);
        FTNotValidTime.setToValue(0.0);
        FTNotValidTime.setAutoReverse(true);
        FTNotValidTime.play();
    }


    /**
     * Checks if the user inputs for startTime and endTime are valid times, and returns a boolean
     * Valid time means it fits in a 24 Hours clock in the format of "HH:MM"
     *
     * @param startTime user inputted start time
     * @param endTime   user inputted end time
     * @return returns true if user input times are valid
     */
    public boolean inputTimeChecker(String startTime, String endTime) {
        String[] time = (startTime + ":" + endTime).split(":");
        return (startTime.matches("\\d{2}:\\d{2}")) &&
                (endTime.matches("\\d{2}:\\d{2}")) &&
                (Integer.parseInt(time[0]) <= 24) && (Integer.parseInt(time[0]) > 0) &&
                (Integer.parseInt(time[2]) <= 24) && (Integer.parseInt(time[2]) > 0) &&
                (Integer.parseInt(time[1]) <= 59) && (Integer.parseInt(time[3]) <= 59);
    }

    /**
     * Calls the presenter to show that Users username on the header
     *
     * @param name username
     */
    public void setUsernameChangeLabel(String name) {
        eventsPresenter.setUsernameChangeLabel(name, calendar);
    }

    /**
     * Called when user clicks the "Add Future Event" button
     */
    public void futureEventButton() {
        CreateNewEntryScreen.newForm();
    }


    /**
     * Loads the timetable onto the dashboard
     */
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

    /**
     * Loads the to-do list onto the dashboard
     */
    public void loadTODO(GridPane TODO) throws IOException {
        eventsPresenter.loadTODO(TODO);
    }

    /**
     * If user decides not to add future event, this button will close that screen
     */
    public void cancelEventAction(Button cancelButton) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}