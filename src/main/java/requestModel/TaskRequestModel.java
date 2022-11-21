package requestModel;

import entity.Category;

import java.time.LocalDate;

public class TaskRequestModel {
    private String title;

    private LocalDate date;

    private String privacySetting;

    private Category category;

    public TaskRequestModel(String title, LocalDate date, String privacySetting, Category category) {
        this.title = title;
        this.date = date;
        this.privacySetting = privacySetting;
        this.category = category;
    }

    public String getTitle() {
        return this.title;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public String getPrivacySetting() {
        return this.privacySetting;
    }

    public Category getCategory() {
        return this.category;
    }
}
