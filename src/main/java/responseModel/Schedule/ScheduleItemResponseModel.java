package responseModel.Schedule;

import java.time.LocalDate;
import java.time.LocalTime;

public class ScheduleItemResponseModel {

    private String title;

    private String startDate;

    private String endDate;

    private String startTime;

    private String endTime;

    public ScheduleItemResponseModel(String title, String startDate, String endDate,
                                     String startTime, String endTime) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getTitle() {
        return this.title;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }
}

