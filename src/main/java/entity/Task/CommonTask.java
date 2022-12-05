package entity.Task;

import java.time.LocalDate;
//get rid of privacySetting
public class CommonTask implements Task {

    private String description;

    private String date;

    private String category;

    public CommonTask(String description, String date, String category) {
        this.description = description;
        this.date = date;
        this.category = category;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public String getDate() {
        return this.date;
    }

    @Override
    public String getCategory() {
        return this.category;
    }

    public void setDescription(String newDescription ) {
        this.description = newDescription;
    }

    public void setDate(String newDate) {
        this.date = newDate;
    }

    public void setCategory(String newCategory) {
        this.category = newCategory;
    }
}