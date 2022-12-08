package responseModel.Import;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ImportResponseModel {
    private final ArrayList<String> titles;
    private final ArrayList<LocalDate> startDates;
    private final ArrayList<LocalDate> endDates;
    private final ArrayList<LocalTime> startTimes;
    private final ArrayList<LocalTime> endTimes;
    private final ArrayList<String> rRules;

    public ImportResponseModel(ArrayList<String> titles, ArrayList<LocalDate> startDates,
                               ArrayList<LocalDate> endDates, ArrayList<LocalTime> startTimes,
                               ArrayList<LocalTime> endTimes, ArrayList<String> rRules) {
        this.titles = titles;
        this.startDates = startDates;
        this.endDates = endDates;
        this.startTimes = startTimes;
        this.endTimes = endTimes;
        this.rRules = rRules;
    }

    public ArrayList<String> getTitles() {
        return this.titles;
    }

    public ArrayList<String> getRRules() {
        return this.rRules;
    }

    public ArrayList<LocalDate> getStartDates() {
        return this.startDates;
    }

    public ArrayList<LocalDate> getEndDates() {
        return this.endDates;
    }

    public ArrayList<LocalTime> getStartTimes() {
        return this.startTimes;
    }

    public ArrayList<LocalTime> getEndTimes() {
        return this.endTimes;
    }
}
