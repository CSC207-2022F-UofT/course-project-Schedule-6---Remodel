package entity.Task;

import java.time.LocalDate;

public interface Task {

    String getDescription();

    LocalDate getDate();

    String getCategory();
}
