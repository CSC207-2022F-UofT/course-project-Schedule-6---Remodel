package entity.Event;

import java.time.LocalDate;
import java.time.LocalTime;

public class CommonEventItem implements EventItem {

    private String title;

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalTime startTime;

    private LocalTime endTime;

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