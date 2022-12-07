package entity.Event;

import java.time.LocalDate;
import java.time.LocalTime;

public class CommonEventItemFactory implements EventItemFactory {
    @Override
    public EventItem create(String title, LocalDate startDate, LocalDate endDate,
                            LocalTime startTime, LocalTime endTime) {
        return new CommonEventItem(title, startDate, endDate, startTime, endTime);
    }
}
