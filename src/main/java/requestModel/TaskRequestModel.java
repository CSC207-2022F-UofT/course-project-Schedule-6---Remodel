package requestModel;

import java.time.LocalDate;

public class TaskRequestModel {

    private String title;

    private LocalDate date;

    private String category;

    private Boolean isPrivate;

    public TaskRequestModel(String title, LocalDate date, Boolean isPrivate, String category){
        this.title = title;
        this.date = date;
        this.isPrivate = isPrivate;
        this.category = category;
    }

    public String getTitle(){ return this.title;}

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
