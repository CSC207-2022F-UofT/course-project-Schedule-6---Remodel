package useCaseInteractor.Event;

import boundary.Event.LoadEventsInputBoundary;
import boundary.Event.LoadEventsOutputBoundary;
import responseModel.Event.LoadEventsResponseModel;
import useCaseInteractor.DataAccess;

import java.util.ArrayList;

public class loadEventsUseCase implements LoadEventsInputBoundary {

    final DataAccess dataAccess;

    final LoadEventsOutputBoundary outputBoundary;

    public loadEventsUseCase(DataAccess dataAccess, LoadEventsOutputBoundary outputBoundary) {
        this.dataAccess = dataAccess;
        this.outputBoundary = outputBoundary;
    }

    public void loadEvents() {
        ArrayList<ArrayList<Object>> lst = dataAccess.getUserEvents();
        LoadEventsResponseModel responseModel = new LoadEventsResponseModel(lst);
        outputBoundary.loadEvents(responseModel);
    }
}
