package entity.Schedule;

import java.time.LocalDate;
import java.time.LocalTime;

public class CommonScheduleItemFactory implements ScheduleItemFactory {
    @Override
    public ScheduleItem create(String title, LocalDate startDate, LocalDate endDate,
                               LocalTime startTime, LocalTime endTime) {
        return new CommonScheduleItem(title, startDate, endDate, startTime, endTime);
    }
}
