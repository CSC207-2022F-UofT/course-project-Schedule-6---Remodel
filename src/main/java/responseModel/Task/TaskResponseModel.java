package responseModel.Task;

import java.time.LocalDate;

public class TaskResponseModel {
    private String description;

    private LocalDate date;

    private String category;

    private Boolean isPrivate;

    public TaskResponseModel(String description, LocalDate date, Boolean isPrivate, String category){
        this.description = description;
        this.date = date;
        this.isPrivate = isPrivate;
        this.category = category;
    }

    public String getDescription(){ return this.description;}

    public LocalDate getDate(){ return this.date;}

    public String getPrivacy(){
        if(isPrivate){
            return "Private";
        } else {
            return "Public";
        }
    }

    public String getCategory() { return this.category;}
}
