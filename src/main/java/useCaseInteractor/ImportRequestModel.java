package useCaseInteractor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ImportRequestModel {

    private ArrayList<String> titles;

    private ArrayList<String> starts;

    private ArrayList<String> ends;

    public ImportRequestModel(ImportDsRequestModel data) {
        this.titles = data.getTitles();
        this.starts = data.getStartDates();
        this.ends = data.getEndDates();
    }

    public ArrayList<String> getTitles(){
        return this.titles;
    }

    public ArrayList<LocalDate> getDates(){}

    public ArrayList<LocalTime> getStartTimes(){}

    public ArrayList<LocalTime> getEndTimes(){}
}
