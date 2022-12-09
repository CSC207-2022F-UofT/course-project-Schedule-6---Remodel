package requestModel;


public class TaskRequestModel {

    private final String description;

    private final String date;

    private final String category;


    /**
     * Input data from the User
     * Used to create a new Task entity in the use case
     *
     * @param description description of the task
     * @param date        deadline of the task
     * @param category    the category that this task falls under
     */
    public TaskRequestModel(String description, String date, String category) {
        this.description = description;
        this.date = date;
        this.category = category;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDate() {
        return this.date;
    }

    public String getCategory() {
        return this.category;
    }

}
