package entity.Task;

import java.time.LocalDate;

public interface TaskFactory {
    Task create(String description, LocalDate date, boolean privacySetting, String category);
}
