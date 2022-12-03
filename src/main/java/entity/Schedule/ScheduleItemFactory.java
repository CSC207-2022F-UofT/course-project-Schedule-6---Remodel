package entity.Schedule;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ScheduleItemFactory {
    ScheduleItem create(String title, String startDate, String endDate, String startTime, String endTime);
}
