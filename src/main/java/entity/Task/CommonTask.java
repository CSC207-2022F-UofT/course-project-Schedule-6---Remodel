package entity.Task;

import java.time.LocalDate;
//get rid of privacySetting
public class CommonTask implements Task {

    private String description;

    private LocalDate date;

    private String category;

    public CommonTask(String description, LocalDate date, String category) {
        this.description = description;
        this.date = date;
        this.category = category;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public LocalDate getDate() {
        return this.date;
    }

    @Override
    public String getCategory() {
        return this.category;
    }
}