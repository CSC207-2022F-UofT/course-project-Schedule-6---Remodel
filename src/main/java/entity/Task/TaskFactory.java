package entity.Task;

public interface TaskFactory {
    Task create(String description, String date, String category);
}
