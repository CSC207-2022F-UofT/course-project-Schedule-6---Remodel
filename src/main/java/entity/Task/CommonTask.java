package entity.Task;

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

    @Override
    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    @Override
    public void setDate(String newDate) {
        this.date = newDate;
    }

    @Override
    public void setCategory(String newCategory) {
        this.category = newCategory;
    }
}