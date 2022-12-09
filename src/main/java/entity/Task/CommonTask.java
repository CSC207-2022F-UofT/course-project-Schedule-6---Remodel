package entity.Task;

public class CommonTask implements Task {

    private String description;

    private String date;

    private String category;

    /**
     * This entity is a single Task created by the User
     *
     * @param description description of the task
     * @param date        deadline of the task
     * @param category    the category that this task falls under
     */
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