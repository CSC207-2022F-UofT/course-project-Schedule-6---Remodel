package responseModel.Import;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * The response model for importing ics files
 */
public class ImportResponseModel {
    private final ArrayList<String> TITLES;
    private final ArrayList<LocalDate> SD;
    private final ArrayList<LocalDate> ED;
    private final ArrayList<LocalTime> ST;
    private final ArrayList<LocalTime> ET;
    private final ArrayList<String> RULES;

    /**
     * The constructor of ImportResponseModel
     * @param titles of EventItems
     * @param startDates of EventItems
     * @param endDates of EventItems
     * @param startTimes of EventItems
     * @param endTimes of EventItems
     * @param rRules of EventItems
     */
    public ImportResponseModel(ArrayList<String> titles, ArrayList<LocalDate> startDates,
                               ArrayList<LocalDate> endDates, ArrayList<LocalTime> startTimes,
                               ArrayList<LocalTime> endTimes, ArrayList<String> rRules){
        this.TITLES = titles;
        this.SD = startDates;
        this.ED = endDates;
        this.ST = startTimes;
        this.ET = endTimes;
        this.RULES = rRules;
    }

    /**
     * @return the titles of all EventItems created as an ArrayList of Strings
     */
    public ArrayList<String> getTitles(){
        return this.TITLES;
    }

    /**
     * @return the recurrence rules of all EventItems created as an ArrayList of Strings
     */
    public ArrayList<String> getRRules(){
        return this.RULES;
    }

    /**
     * @return the start dates of all EventItems created as an ArrayList of LocalDate
     */
    public ArrayList<LocalDate> getStartDates(){
        return this.SD;
    }

    /**
     * @return the end dates of all EventItems created as an ArrayList of LocalDate
     */
    public ArrayList<LocalDate> getEndDates(){
        return this.ED;
    }

    /**
     * @return the start times of all EventItems created as an ArrayList of LocalTime
     */
    public ArrayList<LocalTime> getStartTimes(){
        return this.ST;
    }

    /**
     * @return the end times of all EventItems created as an ArrayList of LocalTime
     */
    public ArrayList<LocalTime> getEndTimes(){
        return this.ET;
    }
}
