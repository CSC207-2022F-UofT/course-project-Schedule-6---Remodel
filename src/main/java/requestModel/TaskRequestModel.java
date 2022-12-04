package requestModel;


import java.time.LocalDate;

public class TaskRequestModel {

    private String description;

    private LocalDate date;

    private String category;

    public TaskRequestModel(String description, LocalDate date, String category){
        this.description = description;
        this.date = date;
        this.category = category;
    }

    public String getDescription(){ return this.description;}

    public LocalDate getDate(){ return this.date;}

    public String getCategory() { return this.category;}

}
