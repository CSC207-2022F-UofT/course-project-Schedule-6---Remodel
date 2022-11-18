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

import java.time.LocalDate;
import java.time.LocalTime;


public class TimetableController {

    @FXML
    private Label TimetableUserName;
    @FXML
    private GridPane Gridlock;
    public static Label usernameChageLabel;

    private CalendarView calendar;


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
