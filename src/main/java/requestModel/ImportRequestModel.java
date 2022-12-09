package requestModel;

import useCaseInteractor.Import.IcsParser;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ImportRequestModel {

    private final ArrayList<String> titles;

    private final ArrayList<String> starts;

    private final ArrayList<String> ends;

    private final ArrayList<String> rRules;


    /**
     * Used in the import use cases
     *
     * @param data parsed data from the ICS file
     */
    public ImportRequestModel(IcsParser data) {
        this.titles = data.getTitles();
        this.starts = data.getStartDates();
        this.ends = data.getEndDates();
        this.rRules = data.getRRules();
    }

    public ArrayList<String> getTitles() {
        return this.titles;
    }

    public ArrayList<String> getRRules() {
        return this.rRules;
    }

    public ArrayList<LocalDate> getStartDates() {
        return getDates(this.starts);
    }

    public ArrayList<LocalDate> getEndDates() {
        return getDates(this.ends);
    }

    private ArrayList<LocalDate> getDates(ArrayList<String> input) {
        ArrayList<LocalDate> dates = new ArrayList<>();
        for (String dateEntry : input) {
            int index = dateEntry.indexOf("2"); //The index where the date expression starts
            LocalDate localDate = LocalDate.parse(dateEntry.substring(index, index + 8),
                    DateTimeFormatter.ofPattern("yyyyMMdd"));
            dates.add(localDate);
        }
        return dates;
    }

    public ArrayList<LocalTime> getStartTime() {
        return getTime(this.starts);
    }

    public ArrayList<LocalTime> getEndTime() {
        return getTime(this.ends);
    }

    private ArrayList<LocalTime> getTime(ArrayList<String> input) {
        ArrayList<LocalTime> timeList = new ArrayList<>();
        for (String dateEntry : input) {
            int index = dateEntry.indexOf("2"); //The index where the date expression starts
            LocalTime localTime = LocalTime.parse(dateEntry.substring(index + 9, index + 13),
                    DateTimeFormatter.ofPattern("HHmm"));
            timeList.add(localTime);
        }
        return timeList;
    }
}