package requestModel;


import java.time.LocalDate;

public class TaskRequestModel {

    private String descripiton;

    private LocalDate date;

    private String category;

    public TaskRequestModel(String descripiton, LocalDate date, String category){
        this.descripiton = descripiton;
        this.date = date;
        this.category = category;
    }

    public String getDescription(){ return this.descripiton;}

    public LocalDate getDate(){ return this.date;}

    public String getCategory() { return this.category;}

}
