package responseModel.Event;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventItemResponseModel {

    private final String title;

    private final LocalDate startDate;

    private final LocalDate endDate;

    private final LocalTime startTime;

    private final LocalTime endTime;

    public EventItemResponseModel(String title, LocalDate startDate, LocalDate endDate,
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

