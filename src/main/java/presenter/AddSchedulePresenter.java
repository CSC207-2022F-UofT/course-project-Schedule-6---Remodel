package presenter;

import boundary.Schedule.UpdateScheduleOutputBoundary;
import javafx.scene.control.Label;

public class AddSchedulePresenter implements UpdateScheduleOutputBoundary {
    @Override
    public void prepareSuccessView(Label text, String message) {
        text.setText(message);
    }

    @Override
    public void prepareFailView(Label text, String message) {
        text.setText(message);
    }
}
