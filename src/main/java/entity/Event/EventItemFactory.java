package entity.Event;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Interface the CommonEventItemFactory implements
 */
public interface EventItemFactory {
    /**
     * create() takes in required parameters for creating an EventItem entity, and returns that EventItem
     *
     * @param title     title of the event
     * @param startDate start date of the event
     * @param endDate   end date of the event
     * @param startTime start time of the event
     * @param endTime   end time of the event
     * @return returns entity CommonEventItem
     */
    EventItem create(String title, LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime);
}
