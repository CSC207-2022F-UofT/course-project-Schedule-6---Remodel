package controller.Task;

import entity.Task.CommonTask;
import javafx.event.ActionEvent;
import screens.CreateAddTaskScreen;
import screens.CreateEditTaskScreen;
import screens.EditTaskScreen;

import java.time.LocalDate;

public class ToDoController {
    public void todoAddAction(ActionEvent event){
        CreateAddTaskScreen.newForm();

    }

    public void todoEditButton(ActionEvent event, CommonTask selectedTask){



        CreateEditTaskScreen.newForm();
    }
}
