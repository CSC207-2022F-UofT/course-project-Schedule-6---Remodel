package presenter;

import javafx.animation.FadeTransition;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class ToDoPresenter {
    public void setText(TextField newTaskDescription, TextField newTaskDate, TextField newTaskCategory) {
        newTaskDescription.setText("");
        newTaskDate.setText("");
        newTaskCategory.setText("");
    }

    public void setError(Label errorMessage) {
        errorMessage.setText("FILL IN ALL FIELDS");
        FadeTransition ft = new FadeTransition(Duration.millis(2850), errorMessage);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setAutoReverse(true);
        ft.play();
    }

    public void setDateError(Label errorMessage) {
        errorMessage.setText("ENTER DATE IN FORMAT YYYY-MM-DD");
        FadeTransition ft = new FadeTransition(Duration.millis(2850), errorMessage);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setAutoReverse(true);
        ft.play();
    }
}
