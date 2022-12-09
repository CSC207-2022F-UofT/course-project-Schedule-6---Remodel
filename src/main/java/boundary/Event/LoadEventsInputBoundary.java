package boundary.Event;

/**
 * Interface for loadEventsUseCase
 * Allows the controller (TimetableController) to call the use case (loadEventsUseCase)
 */
public interface LoadEventsInputBoundary {

    /**
     * Called when User logs in
     */
    void loadEvents();
}
