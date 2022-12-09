package entity.Event;

import java.time.LocalDate;
import java.time.LocalTime;

public class CommonEventItem implements EventItem {

    private final String title;

    private final LocalDate startDate;

    private final LocalDate endDate;

    private final LocalTime startTime;

    private final LocalTime endTime;

    /**
     * This entity is a single event that contains info about an event
     *
     * @param title     title of event
     * @param startDate start date of the event
     * @param endDate   end date of the event
     * @param startTime start time of the event in 24 Hour time
     * @param endTime   end time of the event in 24 Hour time
     */
    public CommonEventItem(String title, LocalDate startDate, LocalDate endDate,
                           LocalTime startTime, LocalTime endTime) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public LocalDate getStartDate() {
        return this.startDate;
    }

    @Override
    public LocalDate getEndDate() {
        return this.endDate;
    }

    @Override
    public LocalTime getStartTime() {
        return this.startTime;
    }

    @Override
    public LocalTime getEndTime() {
        return this.endTime;
    }
}