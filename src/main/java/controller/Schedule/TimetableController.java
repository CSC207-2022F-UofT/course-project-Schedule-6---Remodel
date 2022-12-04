package controller.Schedule;

import com.calendarfx.model.Entry;
import com.calendarfx.view.CalendarView;
import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarSource;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import entity.Schedule.TimeManagement;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import database.MongoDBAccess;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javafx.util.Duration;
import main.LoginPage;
import presenter.AddSchedulePresenter;
import presenter.TimetablePresenter;
import screens.CreateNewEntryScreen;
import screens.CreateRegistrationScreen;
import screens.CreateScheduleScreen;
import useCaseInteractor.User.userCollection;
import main.collectCollection;
import javafx.stage.Stage;

public class TimetableController {
    public static CalendarView calendar = new CalendarView();
    private TimetablePresenter TTP = new TimetablePresenter();

    public void showSchedule(ActionEvent event) {
        TTP.showSchedule(calendar);
    }

    public void printCalendarEntries(ActionEvent event, Label entriesSaved)
    {TTP.printCalendarEntries(entriesSaved);}

    public void addScheduleAction(ActionEvent event, TextField scheduleTitle, DatePicker startDate,
                                  DatePicker endDate, TextField startTime, TextField endTime, Label errorMessage)
    {TTP.addScheduleAction(scheduleTitle, startDate, endDate, startTime, endTime, errorMessage);}

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
        TTP.loadTODO(TODO);
}
    public void addNewFile(ActionEvent event, Button fileImportButton, Stage stage){

        FileChooser file_chooser = new FileChooser();
        file_chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.ics"));
        EventHandler<ActionEvent> e = e1 -> {
            // get the file selected
            File file = file_chooser.showOpenDialog(stage);
            };
        fileImportButton.setOnAction(e);
    }
}