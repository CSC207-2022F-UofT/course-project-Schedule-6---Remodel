package entity.Event;

import java.time.LocalDate;
import java.time.LocalTime;

public interface EventItemFactory {
    EventItem create(String title, LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime);
}
