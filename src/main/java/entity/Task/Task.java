package entity.Task;

import java.time.LocalDate;

public interface Task {

    String getTitle();

    LocalDate getDate();

    Boolean getPrivacySetting();

    String getCategory();
}
