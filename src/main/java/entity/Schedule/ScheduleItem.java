package entity.Schedule;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ScheduleItem {
    String getTitle();

    String getStartDate();

    String getEndDate();

    String getStartTime();

    String getEndTime();
}
