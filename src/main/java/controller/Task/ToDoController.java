package controller.Task;

import entity.Task.CommonTask;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import presenter.ToDoPresenter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ToDoController {
    private ToDoPresenter TDP = new ToDoPresenter();
    public void addNewEntry(TableView<CommonTask> todoTable, TextField newTaskDescription,
                            TextField newTaskDate, TextField newTaskCategory, Label errorMessage) {

        if (newTaskDescription.getText().isBlank() || newTaskCategory.getText().isBlank() || newTaskDate.getText().isBlank()) {
            TDP.setError(errorMessage);
        } else {
            if (checkFormat(newTaskDate.getText())) {
                todoTable.getItems().add(new CommonTask(newTaskDescription.getText(),
                        newTaskDate.getText(), newTaskCategory.getText()));
                TDP.setText(newTaskDescription, newTaskDate, newTaskCategory);
            } else {
                TDP.setDateError(errorMessage);
            }
        }
    }

    private boolean checkFormat(String text) {
        String[] lst = text.split("-");
        return text.matches("\\d{4}-\\d{2}-\\d{2}") &&
                ((Integer.parseInt(lst[0]) > 0) && Integer.parseInt(lst[0]) < 10000) &&
                ((Integer.parseInt(lst[1]) > 0) && Integer.parseInt(lst[1]) <= 12) &&
                ((Integer.parseInt(lst[2]) > 0) && Integer.parseInt(lst[2]) <= 31);
    }
}
