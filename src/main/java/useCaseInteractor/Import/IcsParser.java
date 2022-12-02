package useCaseInteractor.Import;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.component.CalendarComponent;
import net.fortuna.ical4j.model.component.VEvent;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class IcsParser {
    private List<CalendarComponent> components;

    public IcsParser(FileInputStream in) throws ParserException, IOException {
        CalendarBuilder builder = new CalendarBuilder();
        //try{
            Calendar calendar = builder.build(in);
            this.components = calendar.getComponents();
        //}
        //catch(IOException | ParserException e){
            //e.printStackTrace();
        //}
    }

    public ArrayList<String> getTitles(){
        ArrayList<String> titles = new ArrayList<>();
        for (CalendarComponent component:this.components) {
            if (component instanceof VEvent) {
                String eventSummary = String.valueOf(component.getProperty(Property.SUMMARY));
                String title = eventSummary.substring(eventSummary.indexOf(":") + 1, eventSummary.indexOf("]"));
                titles.add(title.strip());
            }
        }
        return titles;
    }

    public ArrayList<String> getStartDates(){
        ArrayList<String> stDates = new ArrayList<>();
        for (CalendarComponent component:this.components) {
            if (component instanceof VEvent) {
                String eventStDate = String.valueOf(component.getProperty(Property.DTSTART));
                String stDate = eventStDate.substring(eventStDate.indexOf(":") + 1, eventStDate.indexOf("]"));
                stDates.add(stDate.strip());
            }
        }
        return stDates;
    }

    public ArrayList<String> getEndDates(){
        ArrayList<String> endDates = new ArrayList<>();
        for (CalendarComponent component:this.components) {
            if (component instanceof VEvent) {
                String eventEndDate = String.valueOf(component.getProperty(Property.DTEND));
                String endDate = eventEndDate.substring(eventEndDate.indexOf(":") + 1, eventEndDate.indexOf("]"));
                endDates.add(endDate.strip());
            }
        }
        return endDates;
    }

}
