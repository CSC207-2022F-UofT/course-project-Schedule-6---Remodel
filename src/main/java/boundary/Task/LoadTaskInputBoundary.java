package boundary.Task;

/**
 * Interface for LoadTasksUseCase
 * Allows the controller (TaskController) to call the use case (LoadTasksUseCase)
 */
public interface LoadTaskInputBoundary {
    void loadTasks();
}
