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

    /**
     * Overrides loadEvents() method in its interfaces' method (LoadEventsInputBoundary)
     * This method is called when the User logs in
     * It calls the MongoDBAccess interface (dataAccess) and creates a LoadEventsResponseModel
     * which contains an ArrayList of all the events of this User and
     * calls the presenter through the interface (LoadEventsOutputBoundary)
     */
    @Override
    public void loadEvents() {
        ArrayList<ArrayList<Object>> lst = dataAccess.getUserEvents();
        LoadEventsResponseModel responseModel = new LoadEventsResponseModel(lst);
        outputBoundary.loadEvents(responseModel);
    }
}
