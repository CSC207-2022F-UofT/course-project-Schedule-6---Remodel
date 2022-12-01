package entity.Task;

import java.time.LocalDate;

public interface TaskFactory {
    Task create(String title, LocalDate date, Boolean privacySetting, String category);
}
