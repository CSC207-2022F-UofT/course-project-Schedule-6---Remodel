package entity.Task;

public class CommonTaskFactory implements TaskFactory {

    /**
     * Overrides create() method in TaskFactory
     * create() takes in required parameters for creating an CommonTask, and returns that entity.
     *
     * @param description description of the task
     * @param date        deadline of the task
     * @param category    the category that this task falls under
     * @return the new CommonTask
     */
    @Override
    public Task create(String description, String date, String category) {
        return new CommonTask(description, date, category);
    }

}
