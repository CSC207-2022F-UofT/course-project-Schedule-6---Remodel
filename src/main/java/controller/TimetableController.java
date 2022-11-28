package controller;

import com.calendarfx.view.CalendarView;
import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarSource;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
//import screens.scheduleInputsScreen;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;


public class TimetableController {

    @FXML
    private Label TimetableUserName;
    @FXML
    private GridPane Gridlock;
    @FXML
    private Button saveButton;
    @FXML
    private Button newEvent;
    public static Label usernameChageLabel;

    private CalendarView calendar;

    ZoneId TIMEZONE_ET = ZoneId.of("America/Toronto");
    LocalDate startDate = LocalDate.of(-99999,1,1);
    LocalDate endDate = LocalDate.of(99999,12,31);
    @FXML
    private void printCalendarEntries(){
        for (Calendar temp : calendar.getCalendars()) {
            System.out.println(temp.findEntries(startDate, endDate, TIMEZONE_ET));
        }
    }
    @FXML
    //public void scheduleInputsButton(ActionEvent event){scheduleInputsScreen.newForm();}



    private void loadCalendar() {
        calendar = new CalendarView();

        Calendar classes = new Calendar("null");
        Calendar meetings = new Calendar("Meetings");

        classes.setStyle(Calendar.Style.STYLE7);
        meetings.setStyle(Calendar.Style.STYLE2);

        CalendarSource myCalendarSource = new CalendarSource("Timetable");
        myCalendarSource.getCalendars().addAll(classes, meetings);

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
        //calendar.showMonthPage();
        calendar.showWeekPage();
        calendar.setShowAddCalendarButton(true);
        calendar.setShowPrintButton(false);
        calendar.setShowDeveloperConsole(false);
        Gridlock.getChildren().add(calendar);
    }

    public void initialize(){
        usernameChageLabel = TimetableUserName;
        loadCalendar();
    }
}
