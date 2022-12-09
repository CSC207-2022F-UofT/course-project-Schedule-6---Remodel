package entity.Task;

/**
 * CommonTaskFactory interface for the use case layer to use
 */
public interface TaskFactory {
    /**
     * create() takes in required parameters for creating a Task entity, and returns that Task
     *
     * @param description description of the task
     * @param date        deadline of the task
     * @param category    the category that this task falls under
     * @return the new CommonTask
     */
    Task create(String description, String date, String category);
}
