package boundary.Task;

import javafx.scene.control.Label;

public interface TaskCreationOutputBoundary {
    void prepareSuccessView(Label message, String error);

    void prepareFailView(Label message, String error);
}
