package presenter;

import boundary.Task.LoadTasksOutputBoundary;
import javafx.animation.FadeTransition;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import responseModel.Task.LoadTasksResponseModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TaskPresenter implements LoadTasksOutputBoundary {
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

    public void saveTasksMessage(Label errorMessage) {
        errorMessage.setText("ALL TASKS SAVED");
        FadeTransition ft = new FadeTransition(Duration.millis(1850), errorMessage);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setAutoReverse(true);
        ft.play();
    }

    @Override
    public void loadTasks(LoadTasksResponseModel allTasks, TableView tableView) {
        for (ArrayList<Object> task : allTasks.getAllTasks()) {
            Map<String, Object> item = new HashMap<>();
            item.put("Description", task.get(0).toString());
            item.put("Date", task.get(1).toString());
            item.put("Category", task.get(2).toString());
            tableView.getItems().add(item);
        }
    }
}
