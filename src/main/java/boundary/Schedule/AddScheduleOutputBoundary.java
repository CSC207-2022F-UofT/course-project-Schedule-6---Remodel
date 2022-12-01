package boundary.Schedule;

import javafx.scene.control.Label;
import responseModel.Schedule.ScheduleItemResponseModel;

public interface AddScheduleOutputBoundary {
    void prepareSuccessView(Label message, String error);

    void prepareFailView(Label message, String error);
}
