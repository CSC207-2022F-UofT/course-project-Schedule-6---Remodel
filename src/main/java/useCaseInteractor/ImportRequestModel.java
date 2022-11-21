package useCaseInteractor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ImportRequestModel {

    private final ArrayList<String> titles;

    private final ArrayList<String> starts;

    private final ArrayList<String> ends;

    public ImportRequestModel(IcsParser data) {
        this.titles = data.getTitles();
        this.starts = data.getStartDates();
        this.ends = data.getEndDates();
    }

    public ArrayList<String> getTitles(){
        return this.titles;
    }

    public ArrayList<LocalDate> getDates(){
        ArrayList<LocalDate> dates = new ArrayList<>();
        for (String dateEntry : this.starts) {
            int index = dateEntry.indexOf("2"); //The index where the date expression starts
            LocalDate localDate = LocalDate.parse(dateEntry.substring(index, index + 8),
                    DateTimeFormatter.ofPattern("yyyyMMdd"));
            dates.add(localDate);
        }
        return dates;
    }

    public ArrayList<LocalTime> getStartTime(){
        return getTime(this.starts);
    }

    public ArrayList<LocalTime> getEndTime() {
        return getTime(this.ends);
    }

    private ArrayList<LocalTime> getTime(ArrayList<String> input){
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