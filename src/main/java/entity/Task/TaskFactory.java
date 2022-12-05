package entity.Task;

import java.time.LocalDate;

public interface TaskFactory {
    Task create(String description, String date, String category);
}
