package presenter;

import boundary.Schedule.AddScheduleOutputBoundary;
import javafx.scene.control.Label;
import responseModel.Schedule.ScheduleItemResponseModel;

public class AddSchedulePresenter implements AddScheduleOutputBoundary {
    @Override
    public void prepareSuccessView(Label text, String message) {
        text.setText(message);
    }

    @Override
    public void prepareFailView(Label text, String message) {
        text.setText(message);
    }
}
