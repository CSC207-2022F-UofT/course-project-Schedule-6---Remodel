package entity.Task;

import java.time.LocalDate;

public class CommonTaskFactory implements TaskFactory {
    @Override
    public Task create(String description, LocalDate date, String category) {
        return new CommonTask(description, date, category);
    }

}
