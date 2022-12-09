package requestModel;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventItemRequestModel {

    private final String title;

    private final LocalDate startDate;

    private final LocalDate endDate;

    private final LocalTime startTime;

    private final LocalTime endTime;

    /**
     * Input data from the User
     * Used to create a new EventItem entity in the use case
     *
     * @param title     title of event
     * @param startDate start date of the event
     * @param endDate   end date of the event
     * @param startTime start time of the event in 24 Hour time
     * @param endTime   end time of the event in 24 Hour time
     */
    public EventItemRequestModel(String title, LocalDate startDate, LocalDate endDate,
                                 LocalTime startTime, LocalTime endTime) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getTitle() {
        return this.title;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public LocalTime getStartTime() {
        return this.startTime;
    }

    public LocalTime getEndTime() {
        return this.endTime;
    }
}
