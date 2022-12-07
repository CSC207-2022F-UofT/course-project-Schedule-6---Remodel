package responseModel.Task;

import java.util.ArrayList;

public class LoadTasksResponseModel {

    final ArrayList<ArrayList<Object>> allTasks;

    public LoadTasksResponseModel(ArrayList<ArrayList<Object>> allTasks) {
        this.allTasks = allTasks;
    }

    public ArrayList<ArrayList<Object>> getAllTasks() {
        return this.allTasks;
    }
}