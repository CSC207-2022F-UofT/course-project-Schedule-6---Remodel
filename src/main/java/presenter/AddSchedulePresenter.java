package presenter;

import boundary.Schedule.UpdateScheduleOutputBoundary;
import com.calendarfx.model.Calendar;
import com.calendarfx.model.Entry;
import com.calendarfx.view.CalendarView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class AddSchedulePresenter implements UpdateScheduleOutputBoundary {
    @Override
    public void prepareSuccessView(Label text, String message) {
        text.setText(message);
    }

    @Override
    public void prepareFailView(Label text, String message) {
        text.setText(message);
    }



}

