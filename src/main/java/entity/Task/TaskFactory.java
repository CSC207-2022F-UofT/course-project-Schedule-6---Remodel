package entity.Task;

import entity.Category.Category;

import java.time.LocalDate;

public interface TaskFactory {
    Task create(String title, LocalDate date, String privacySetting, Category category);
}
