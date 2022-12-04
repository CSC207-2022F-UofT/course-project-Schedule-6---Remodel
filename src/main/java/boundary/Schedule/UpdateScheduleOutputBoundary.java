package boundary.Schedule;

import javafx.scene.control.Label;

public interface UpdateScheduleOutputBoundary {
    void prepareSuccessView(Label message, String error);

    void prepareFailView(Label message, String error);
}
