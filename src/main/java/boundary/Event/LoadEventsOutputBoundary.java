package boundary.Event;

import responseModel.Event.LoadEventsResponseModel;

/**
 * Interface for EventsPresenter
 * Allows use case (loadEventsUseCase) to call the presenter (EventsPresenter)
 */
public interface LoadEventsOutputBoundary {

    /**
     * Takes in users events from the database, and presents that data on a timetable
     *
     * @param responseModel an ArrayList that contains all of a Users events data
     */
    void loadEvents(LoadEventsResponseModel responseModel);
}
