package presenter;

import com.calendarfx.model.Calendar;
import com.calendarfx.view.CalendarView;
import controller.Schedule.TimetableController;
import javafx.animation.FadeTransition;
import javafx.scene.control.Label;
import javafx.util.Duration;
import entity.Schedule.TimeManagement;

import java.util.Map;


public class TimetablePresenter {

    private final TimeManagement TM  = new TimeManagement();


    public void printCalendarEntries(Label entriesSaved, CalendarView calendar) {
        Calendar temp = calendar.getCalendars().get(0);
        Map map = temp.findEntries(TM.getStartDate(), TM.getEndDate(), TM.getTimeZone());
        this.cleanMap(map);


        entriesSaved.setText("ALL ENTIRES SAVED");
        FadeTransition ft = new FadeTransition(Duration.millis(1850), entriesSaved);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setAutoReverse(true);
        ft.play();
    }

    private void cleanMap(Map map){
        Map newMap;
        System.out.println(map);
        System.out.println(map.keySet());
        System.out.println(map.keySet().toArray());
    }
}