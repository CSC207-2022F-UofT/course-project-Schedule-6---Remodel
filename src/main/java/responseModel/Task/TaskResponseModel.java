package responseModel.Task;

import java.time.LocalDate;

public class TaskResponseModel {
    private String title;

    private LocalDate date;

    private String category;

    private Boolean isPrivate;

    public TaskResponseModel(String title, LocalDate date, Boolean isPrivate, String category){
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

    public String getCategory() { return this.category;}

}
