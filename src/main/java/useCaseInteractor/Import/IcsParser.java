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


/**
 * A class that extracts the essential information to create EventItem from an ics file
 */
public class IcsParser {
    private final List<CalendarComponent> COMPONENTS;

    public IcsParser(FileInputStream in) throws ParserException, IOException {
        CalendarBuilder builder = new CalendarBuilder();
        Calendar calendar = builder.build(in);
        this.COMPONENTS = calendar.getComponents();
    }

    /**
     * This method extract the titles of all events in the file
     * @return the titles of all Events as an ArrayList of Strings that corresponds to the order in the file
     */
    public ArrayList<String> getTitles(){
        ArrayList<String> titles = new ArrayList<>();
        for (CalendarComponent component:this.COMPONENTS) {
            if (component instanceof VEvent) {
                String eventSummary = String.valueOf(component.getProperty(Property.SUMMARY));
                String title = eventSummary.substring(eventSummary.indexOf(":") + 1, eventSummary.indexOf("]"));
                titles.add(title.strip());
            }
        }
        return titles;
    }

    /**
     * This method extract the starting dates and time of all events in the file
     * @return the start dates and time of all Events as an ArrayList of Strings that follows the original order
     * in the file.
     */
    public ArrayList<String> getStartDateTime(){
        ArrayList<String> stDates = new ArrayList<>();
        for (CalendarComponent component:this.COMPONENTS) {
            if (component instanceof VEvent) {
                String eventStDate = String.valueOf(component.getProperty(Property.DTSTART));
                String stDate = eventStDate.substring(eventStDate.indexOf(":") + 1, eventStDate.indexOf("]"));
                stDates.add(stDate.strip());
            }
        }
        return stDates;
    }

    /**
     * This method extract the ending dates and time of all events in the file
     * @return the end dates and time of all Events as an ArrayList of Strings that follows the original order
     * in the file.
     */
    public ArrayList<String> getEndDateTime(){
        ArrayList<String> endDates = new ArrayList<>();
        for (CalendarComponent component:this.COMPONENTS) {
            if (component instanceof VEvent) {
                String eventEndDate = String.valueOf(component.getProperty(Property.DTEND));
                String endDate = eventEndDate.substring(eventEndDate.indexOf(":") + 1, eventEndDate.indexOf("]"));
                endDates.add(endDate.strip());
            }
        }
        return endDates;
    }

    /**
     * This method extract the recurrence rules of all events in the file
     * @return the recurrence rules of all Events as an ArrayList of Strings that follows the original order
     * in the file.
     */
    public ArrayList<String> getRRules(){
        ArrayList<String> rRules = new ArrayList<>();
        for (CalendarComponent component:this.COMPONENTS) {
            if (component instanceof VEvent) {
                String rRule = String.valueOf(component.getProperty(Property.RRULE));
                String eventRule = rRule.substring(rRule.indexOf("[") + 1, rRule.lastIndexOf("T"));
                rRules.add(eventRule.strip());
            }
        }
        return rRules;
    }

}
