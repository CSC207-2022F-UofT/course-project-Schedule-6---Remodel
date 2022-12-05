package responseModel.Import;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ImportResponseModel {
    private ArrayList<String> titles;
    private ArrayList<LocalDate> startDates;
    private ArrayList<LocalDate> endDates;
    private ArrayList<LocalTime> startTimes;
    private ArrayList<LocalTime> endTimes;
    private ArrayList<String> rRules;

    public ImportResponseModel(ArrayList<String> titles, ArrayList<LocalDate> startDates,
                               ArrayList<LocalDate> endDates, ArrayList<LocalTime> startTimes,
                               ArrayList<LocalTime> endTimes, ArrayList<String> rRules){
        this.titles = titles;
        this.startDates = startDates;
        this.endDates = endDates;
        this.startTimes = startTimes;
        this.endTimes = endTimes;
        this.rRules = rRules;
    }

    public ArrayList<String> getTitles(){
        return this.titles;
    }

    public ArrayList<String> getRRules(){
        return this.rRules;
    }

    public ArrayList<LocalDate> getStartDates(){
        return this.startDates;
    }

    public ArrayList<LocalDate> getEndDates(){
        return this.endDates;
    }

    public ArrayList<LocalTime> getStartTimes(){
        return this.startTimes;
    }

    public ArrayList<LocalTime> getEndTimes(){
        return this.endTimes;
    }
}
