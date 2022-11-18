package entity;

import java.time.LocalDate;

public interface TaskFactory {
    Task create(String title, LocalDate date, String privacySetting, Category category);
}
