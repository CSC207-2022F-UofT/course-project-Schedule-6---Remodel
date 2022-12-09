package entity.Event;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Interface that CommonEventItem implements
 */
public interface EventItem {
    String getTitle();

    LocalDate getStartDate();

    LocalDate getEndDate();

    LocalTime getStartTime();

    LocalTime getEndTime();
}
