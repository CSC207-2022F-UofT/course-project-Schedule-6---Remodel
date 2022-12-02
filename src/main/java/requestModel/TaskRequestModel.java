package requestModel;


import java.time.LocalDate;

public class TaskRequestModel {

    private String description;

    private LocalDate date;

    private String category;

    private Boolean isPrivate;

    public TaskRequestModel(String description, LocalDate date, Boolean isPrivate, String category){
        this.description = description;
        this.date = date;
        this.isPrivate = isPrivate;
        this.category = category;
    }

    public String getDescription(){ return this.description;}

    public LocalDate getDate(){ return this.date;}

    public Boolean getPrivacy(){
        if(isPrivate){
            return true;
        } else {
            return false;
        }
    }

    public String getCategory() { return this.category;}

}
