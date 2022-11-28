package requestModel;

import entity.CommonCategory;

import java.time.LocalDate;

public class TaskRequestModel {

    private String title;

    private LocalDate date;

    private CommonCategory category;

    private boolean isPrivate;

    public TaskRequestModel(String title, LocalDate date, boolean isPrivate, CommonCategory category){
        this.title = title;
        this.date = date;
        this.isPrivate = isPrivate;
        this.category = category;
    }

    public String getTitle(){ return this.title;}

    public LocalDate getDate(){ return this.date;}

    public String getPrivacy(){
        if(isPrivate){
            return "Private";
        } else {
            return "Public";
        }
    }

    public CommonCategory getCategory() { return this.category;}

}
