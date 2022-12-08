package presenter;

import boundary.Event.LoadEventsOutputBoundary;
import com.calendarfx.model.Calendar;
import com.calendarfx.model.Entry;
import com.calendarfx.view.CalendarView;
import controller.Event.TimetableController;
import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import main.Main;
import responseModel.Event.LoadEventsResponseModel;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class EventsPresenter implements LoadEventsOutputBoundary {

    @Override
    public void loadEvents(LoadEventsResponseModel allEvents) {
        CalendarView calendar = TimetableController.calendar;
        for (Calendar temp : calendar.getCalendars()) {
            temp.clear();
            for (ArrayList<Object> event : allEvents.getAllEvents()) {
                temp.addEntry(createEntry(event));
            }
        }
    }

    public Entry<String> createEntry(ArrayList<Object> events) {
        Entry<String> entry = new Entry<>((String) events.get(0));

        String[] startDate = ((String) events.get(1)).split("-");
        String[] endDate = ((String) events.get(2)).split("-");
        String[] startTime = ((String) events.get(3)).split(":");
        String[] endTime = ((String) events.get(4)).split(":");

        entry.setInterval(
                LocalDate.of(
                        Integer.parseInt(startDate[0]), Integer.parseInt(startDate[1]), Integer.parseInt(startDate[2])),
                LocalTime.of(Integer.parseInt(startTime[0]), Integer.parseInt(startTime[1])),
                LocalDate.of(
                        (Integer.parseInt(endDate[0])), Integer.parseInt(endDate[1]), Integer.parseInt(endDate[2])),
                LocalTime.of(Integer.parseInt(endTime[0]), Integer.parseInt(endTime[1])));
        return entry;
    }

    public void saveEntriesMessage(Label entriesSaved) {
        entriesSaved.setText("ALL ENTIRES SAVED");
        FadeTransition ft = new FadeTransition(Duration.millis(1850), entriesSaved);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setAutoReverse(true);
        ft.play();
    }

    public void loadTODO(GridPane TODO) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getClassLoader().getResource("Tasks.fxml"));
        TODO.getChildren().add(fxmlLoader.load());
    }
}