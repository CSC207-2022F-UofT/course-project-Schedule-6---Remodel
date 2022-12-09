package boundary.Task;

import javafx.scene.control.TableView;
import responseModel.Task.LoadTasksResponseModel;

/**
 * Interface for TaskPresenter
 * Allows the use case (LoadTasksUseCase) to call the presenter (TaskPresenter)
 */
public interface LoadTasksOutputBoundary {
    void loadTasks(LoadTasksResponseModel responseModel, TableView tableView);
}
