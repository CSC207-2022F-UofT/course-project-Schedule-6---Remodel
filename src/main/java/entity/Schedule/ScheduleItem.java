package entity.Schedule;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ScheduleItem {
    String getTitle();

    LocalDate getStartDate();

    LocalDate getEndDate();

    LocalTime getStartTime();

    LocalTime getEndTime();
}
