package entity;

import java.time.LocalDate;

public class CommonTaskFactory implements TaskFactory {
    @Override
    public Task create(String title, LocalDate date, String privacySetting, Category category) {
        return new CommonTask(title, date, privacySetting, category);
    }

}
