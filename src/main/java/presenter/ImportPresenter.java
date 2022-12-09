package presenter;

import boundary.Import.ImportOutputBoundary;
import com.calendarfx.model.Calendar;
import com.calendarfx.model.Entry;
import com.calendarfx.view.CalendarView;
import controller.Event.TimetableController;
import javafx.scene.control.Label;
import responseModel.Import.ImportResponseModel;

/**
 * The presenter for importing files
 */
public class ImportPresenter implements ImportOutputBoundary {

    /**
     * This method adds all the events extracted from the file onto TimeTable
     * @param responseModel keeps track of the attributes of EventItems created
     * @return ImportResponseModel of successful import and EventItem creations
     */
    @Override
    public ImportResponseModel successfulImport(ImportResponseModel responseModel){
        CalendarView calendar = TimetableController.calendar;
        int itemNum = responseModel.getTitles().size(); // the number of events imported from the file
        for(int i = 0; i < itemNum; i++) {
            Entry entry = new Entry(responseModel.getTitles().get(i));
            //sets the days and time for the entry.
            entry.setInterval(responseModel.getStartDates().get(i),
                    responseModel.getStartTimes().get(i),
                    responseModel.getEndDates().get(i),
                    responseModel.getEndTimes().get(i));
            entry.setRecurrenceRule(responseModel.getRRules().get(i));
            for (Calendar temp : calendar.getCalendars()) {
                temp.addEntry(entry);
            }
        }
        return responseModel;
    }

    /**
     * This method notify the user of a failed import
     * @param label displays error message when the import fails
     * @param error is message that notifies the user about the failure
     * @return null
     */
    public ImportResponseModel failedImport(Label label, String error){
        label.setText(error);
        return null;
    }
}
