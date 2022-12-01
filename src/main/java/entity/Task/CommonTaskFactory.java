package entity.Task;

import java.time.LocalDate;

public class CommonTaskFactory implements TaskFactory {
    @Override
    public Task create(String title, LocalDate date, String privacySetting, String category) {
        return new CommonTask(title, date, privacySetting, category);
    }

}
