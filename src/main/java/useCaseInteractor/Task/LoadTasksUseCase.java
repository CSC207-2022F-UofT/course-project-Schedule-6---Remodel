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

    /**
     * This method overrides its interfaces' method (LoadTaskInputBoundary)
     * This method is called when the User logs in
     * It calls the MongoDBAccess interface (dataAccess) and creates a LoadTasksResponseModel
     * which contains an ArrayList of all the tasks of this User and
     * calls the presenter through the interface (LoadTasksOutputBoundary)
     */
    @Override
    public void loadTasks() {
        ArrayList<ArrayList<Object>> lst = dataAccess.getUserTasks();
        LoadTasksResponseModel responseModel = new LoadTasksResponseModel(lst);
        outputBoundary.loadTasks(responseModel, table);
    }
}
