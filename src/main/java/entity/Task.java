package entity;

import java.time.LocalDate;

public interface Task {

    String getTitle();

    LocalDate getDate();

    String getPrivacySetting();

    Category getCategory();
}
