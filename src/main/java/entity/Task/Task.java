package entity.Task;

import java.time.LocalDate;

public interface Task {

    String getTitle();

    LocalDate getDate();

    boolean getPrivacySetting();

    String getCategory();
}
