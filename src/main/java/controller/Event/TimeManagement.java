package controller.Event;

import java.time.LocalDate;
import java.time.ZoneId;

/**
 * Date Setter for calender
 */
public class TimeManagement {
    ZoneId TIMEZONE_ET = ZoneId.of("America/Toronto");
    LocalDate startDate = LocalDate.of(-99999, 1, 1);
    LocalDate endDate = LocalDate.of(99999, 12, 31);

    public ZoneId getTimeZone() {
        return TIMEZONE_ET;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
