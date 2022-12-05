package entity.Schedule;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ScheduleItemFactory {
    ScheduleItem create(String title, LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime);
}
