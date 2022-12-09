package requestModel;

import useCaseInteractor.Import.IcsParser;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * The request model for importing files
 */
public class ImportRequestModel {

    private final ArrayList<String> TITLES;

    private final ArrayList<String> STARTS;

    private final ArrayList<String> ENDS;

    private final ArrayList<String> RULES;

    /**
     * @param data is a parser that extracts the information from the file
     */
    public ImportRequestModel(IcsParser data) {
        this.TITLES = data.getTitles();
        this.STARTS = data.getStartDateTime();
        this.ENDS = data.getEndDateTime();
        this.RULES = data.getRRules();
    }

    /**
     * @return the titles of all events in the file as an ArrayList of Strings.
     */
    public ArrayList<String> getTitles(){
        return this.TITLES;
    }

    /**
     * @return the recurrence rules of all events in the file as an ArrayList of Strings
     */
    public ArrayList<String> getRRules(){
        return this.RULES;
    }

    /**
     * @return the start dates of all events as an ArrayList of LocalDate
     */
    public ArrayList<LocalDate> getStartDates(){
        return getDates(this.STARTS);
    }

    /**
     * @return the end dates of all events as an ArrayList of LocalDate
     */
    public ArrayList<LocalDate> getEndDates(){
        return getDates(this.ENDS);
    }

    /**
     * This private method extract the dates of events from the given entries of Strings
     */
    private ArrayList<LocalDate> getDates(ArrayList<String> input){
        ArrayList<LocalDate> dates = new ArrayList<>();
        for (String dateEntry : input) {
            int index = dateEntry.indexOf("2"); //The index where the date expression starts
            LocalDate localDate = LocalDate.parse(dateEntry.substring(index, index + 8),
                    DateTimeFormatter.ofPattern("yyyyMMdd"));
            dates.add(localDate);
        }
        return dates;
    }

    /**
     * @return the start time of all events as an ArrayList of LocalTime
     */
    public ArrayList<LocalTime> getStartTime(){
        return getTime(this.STARTS);
    }

    /**
     * @return the end time of all events as an ArrayList of LocalTime
     */
    public ArrayList<LocalTime> getEndTime() {
        return getTime(this.ENDS);
    }

    /**
     * This private method extract the time of events from the given entries of Strings
     */
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