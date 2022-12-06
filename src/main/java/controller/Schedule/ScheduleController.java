package controller.Schedule;

import boundary.User.loadUserScheduleInputBoundary;
import com.calendarfx.view.CalendarView;
import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarSource;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.LocalTime;

import database.MongoDBAccess;
import javafx.stage.Stage;
import presenter.SchedulePresenter;
import screens.CreateNewEntryScreen;
import useCaseInteractor.DataAccess;
import useCaseInteractor.User.loadUserSchedule;
import useCaseInteractor.User.userCollection;
import main.collectCollection;

public class ScheduleController {
    public static CalendarView calendar = new CalendarView();

    private final SchedulePresenter schedulePresenter = new SchedulePresenter();

    public void loadSchedule() throws UnknownHostException {
        DataAccess database = new MongoDBAccess(collectCollection.main(), userCollection.getUsername());
        loadUserScheduleInputBoundary schedule = new loadUserSchedule(database);
        schedulePresenter.loadSchedule(calendar, schedule.getSchedule());
    }

    public void printCalendarEntries(ActionEvent event, Label entriesSaved) throws UnknownHostException {
        schedulePresenter.printCalendarEntries(entriesSaved);}

    public void addScheduleAction(ActionEvent event, TextField scheduleTitle, DatePicker startDate,
                                  DatePicker endDate, TextField startTime, TextField endTime, Label errorMessage)
    {
        schedulePresenter.addScheduleAction(scheduleTitle, startDate, endDate, startTime, endTime, errorMessage);}

    public void setUsernameChangeLabel(String name){
        for (Calendar temp: calendar.getCalendars()) {
            temp.setName(name);
        }
    }
    public void futureEventButton(ActionEvent event){
        CreateNewEntryScreen.newForm();}

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
        schedulePresenter.loadTODO(TODO);
    }

    public void cancelScheduleAction(ActionEvent event, Button cancelButton) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}