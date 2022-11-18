package entity;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ScheduleItem {

    String getTitle();

    LocalDate getDate();

    LocalTime getStartTime();

    LocalTime getEndTime();
}
