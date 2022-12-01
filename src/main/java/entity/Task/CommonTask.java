package entity.Task;

import java.time.LocalDate;

public class CommonTask implements Task {

    private String title;

    private LocalDate date;

    private Boolean privacySetting;

    private String category;

    public CommonTask(String title, LocalDate date, Boolean privacySetting, String category) {
        this.title = title;
        this.date = date;
        this.privacySetting = privacySetting;
        this.category = category;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public LocalDate getDate() {
        return this.date;
    }

    @Override
    public Boolean getPrivacySetting() {
        return this.privacySetting;
    }

    @Override
    public String getCategory() {
        return this.category;
    }
}