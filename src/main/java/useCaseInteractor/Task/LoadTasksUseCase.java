package useCaseInteractor.Task;

import boundary.Task.LoadTaskInputBoundary;
import boundary.Task.LoadTasksOutputBoundary;
import javafx.scene.control.TableView;
import responseModel.Task.LoadTasksResponseModel;
import useCaseInteractor.DataAccess;

import java.util.ArrayList;
import java.util.Map;

public class LoadTasksUseCase implements LoadTaskInputBoundary {
    final DataAccess dataAccess;

    final LoadTasksOutputBoundary outputBoundary;

    final TableView<Map> table;

    public LoadTasksUseCase(DataAccess dataAccess, LoadTasksOutputBoundary outputBoundary, TableView<Map> table) {
        this.dataAccess = dataAccess;
        this.outputBoundary = outputBoundary;
        this.table = table;
    }

    @Override
    public void loadTasks() {
        ArrayList<ArrayList<Object>> lst = dataAccess.getUserTasks();
        LoadTasksResponseModel responseModel = new LoadTasksResponseModel(lst);
        outputBoundary.loadTasks(responseModel, table);
    }
}
