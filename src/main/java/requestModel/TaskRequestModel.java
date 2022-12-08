package requestModel;


public class TaskRequestModel {

    private final String description;

    private final String date;

    private final String category;

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
