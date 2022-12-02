package entity.Task;

import java.time.LocalDate;

public class CommonTask implements Task {

    private String description;

    private LocalDate date;

    private Boolean privacySetting;

    private String category;

    public CommonTask(String description, LocalDate date, boolean privacySetting, String category) {
        this.description = description;
        this.date = date;
        this.privacySetting = privacySetting;
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
    public boolean getPrivacySetting() {
        return this.privacySetting;
    }

    @Override
    public String getCategory() {
        return this.category;
    }
}