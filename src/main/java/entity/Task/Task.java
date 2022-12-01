package entity.Task;

import java.time.LocalDate;

public interface Task {

    String getTitle();

    LocalDate getDate();

    String getPrivacySetting();

    String getCategory();
}
