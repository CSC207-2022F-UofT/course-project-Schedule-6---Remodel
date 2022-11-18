package entity;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ScheduleItemFactory {
    ScheduleItem create(String title, LocalDate date, LocalTime startTime, LocalTime endTime);
}
