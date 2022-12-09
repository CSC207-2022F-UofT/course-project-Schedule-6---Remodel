package entity.Event;

import java.time.LocalDate;
import java.time.LocalTime;

public class CommonEventItemFactory implements EventItemFactory {

    /**
     * Overrides create() method in EventItemFactory
     * create() takes in required parameters for creating an CommonEventItem, and returns that entity.
     *
     * @param title     title of event
     * @param startDate start date of the event
     * @param endDate   end date of the event
     * @param startTime start time of the event in 24 Hour time
     * @param endTime   end time of the event in 24 Hour time
     * @return the CommonEvenItem created
     */
    @Override
    public EventItem create(String title, LocalDate startDate, LocalDate endDate,
                            LocalTime startTime, LocalTime endTime) {
        return new CommonEventItem(title, startDate, endDate, startTime, endTime);
    }
}
