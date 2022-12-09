package boundary.Event;

import requestModel.EventItemRequestModel;

/**
 * Interface for UpdateEvenItem use case
 * Allows the controller (TimetableController) to call the use case (UpdateEventItem)
 */
public interface UpdateEventInputBoundary {
    void create(EventItemRequestModel inputData);
}
