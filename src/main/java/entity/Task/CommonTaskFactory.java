package entity.Task;

public class CommonTaskFactory implements TaskFactory {
    @Override
    public Task create(String description, String date, String category) {
        return new CommonTask(description, date, category);
    }

}
