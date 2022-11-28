package entity.Task;

import entity.Category.Category;

import java.time.LocalDate;

public class CommonTask implements Task {

    private String title;

    private LocalDate date;

    private String privacySetting;

    private Category category;

    public CommonTask(String title, LocalDate date, String privacySetting, Category category) {
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
    public String getPrivacySetting() {
        return this.privacySetting;
    }

    @Override
    public Category getCategory() {
        return this.category;
    }
}