package presenter;

import boundary.Task.TaskCreationOutputBoundary;
import javafx.scene.control.Label;


public class TaskCreationPresenter implements TaskCreationOutputBoundary {

    @Override
    public void prepareSuccessView(Label text, String message) {
        text.setText(message);
    }

    @Override
    public void prepareFailView(Label text, String message) {
        text.setText((message));
    }
}
