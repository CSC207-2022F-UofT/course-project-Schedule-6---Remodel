package entity.Task;

import java.time.LocalDate;

public interface TaskFactory {
    Task create(String title, LocalDate date, boolean privacySetting, String category);
}
