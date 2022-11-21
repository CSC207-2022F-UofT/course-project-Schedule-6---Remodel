package useCaseInteractor;

import java.time.LocalDate;
import java.time.LocalTime;

public class ScheduleItemRequestModel {

    private String title;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    public ScheduleItemRequestModel(String title, LocalDate date, LocalTime startTime, LocalTime endTime) {
        this.title = title;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getTitle() {
        return this.title;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public LocalTime getStartTime() {
        return this.startTime;
    }

    public LocalTime getEndTime() {
        return this.endTime;
    }
}