package presenter;

import boundary.Import.ImportOutputBoundary;
import com.calendarfx.model.Calendar;
import com.calendarfx.model.Entry;
import com.calendarfx.view.CalendarView;
import controller.Event.TimetableController;
import javafx.scene.control.Label;
import responseModel.Import.ImportResponseModel;

public class ImportPresenter implements ImportOutputBoundary {

    @Override
    public ImportResponseModel successfulImport(ImportResponseModel responseModel) {
        CalendarView calendar = TimetableController.calendar;
        int itemNum = responseModel.getTitles().size(); // the number of events imported from the file
        for (int i = 0; i < itemNum; i++) {
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

    public void failedImport(Label label, String error) {
        label.setText(error);
    }
    //td: reflect the error on the view
}
