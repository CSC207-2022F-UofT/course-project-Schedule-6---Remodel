package entity.Schedule;

import java.time.LocalDate;
import java.time.LocalTime;

public class CommonScheduleItemFactory implements ScheduleItemFactory {
    @Override
    public ScheduleItem create(String title, String startDate, String endDate,
                               String startTime, String endTime) {
        return new CommonScheduleItem(title, startDate, endDate, startTime, endTime);
    }
}
