package entity.Schedule;

import java.time.LocalDate;
import java.time.LocalTime;

public class CommonScheduleItem implements ScheduleItem {

    private String title;

    private String startDate;

    private String endDate;

    private String startTime;

    private String endTime;

    public CommonScheduleItem(String title, String startDate, String endDate,
                              String startTime, String endTime) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getStartDate() {
        return this.startDate;
    }

    @Override
    public String getEndDate() {
        return this.startDate;
    }

    @Override
    public String getStartTime() {
        return this.startTime;
    }

    @Override
    public String getEndTime() {
        return this.endTime;
    }
}