package entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class CommonScheduleItem implements ScheduleItem {

    private String title;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    public CommonScheduleItem(String title, LocalDate date, LocalTime startTime, LocalTime endTime) {
        this.title = title;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public LocalDate getDate() {
        return this.date;
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