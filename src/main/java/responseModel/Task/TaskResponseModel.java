package responseModel.Task;

import entity.Category.Category;

import java.time.LocalDate;

public class TaskResponseModel {
    public String title;

    public LocalDate date;
    public String privacySetting;

    public Category category;

    public TaskResponseModel(String title, LocalDate date, String privacySetting, Category category){
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
