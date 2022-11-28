package entity.Task;

import entity.Category.Category;

import java.time.LocalDate;

public interface Task {

    String getTitle();

    LocalDate getDate();

    String getPrivacySetting();

    Category getCategory();
}
