package boundary.Event;

import responseModel.Event.LoadEventsResponseModel;

public interface LoadEventsOutputBoundary {
    void loadEvents(LoadEventsResponseModel responseModel);
}
