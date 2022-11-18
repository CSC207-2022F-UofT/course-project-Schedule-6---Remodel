package entity;

public class Task {

    private String name;

    private String date;

    private String description;

    private String time;

    /*
    Constructor of Task
     */
    public Task(String name, String date, String description, String time){
        this.name = name;
        this.date = date;
        this.description = description;
        this.time = time;
    }

    public String getName(){
        return this.name;
    }

    public String getDate(){
        return this.date;
    }

    public String getDescription(){
        return this.description;
    }

    public String getTime(){
        return this.time;
    }

    /*
    Setter function to set each task's name, date, description and time to the given value.
     */
    public void setName(String givenName){
        this.name = givenName;
    }

    public void setDate(String givenDate){
        this.date = givenDate;
    }

    public void setDescription(String givenDescription){
        this.description = givenDescription;
    }

    public void setTime(String givenTime){
        this.time = givenTime;
    }

    /*
    Allow user to edit each task item.
     */

    public void editName(String newName){
        this.name = newName;
    }

    public void editDate(String newDate){
        this.date = newDate;
    }

    public void editDescription(String newDescription){
        this.description = newDescription;
    }

    public void editTime(String newTime){
        this.time = newTime;
    }

    /*
    Return the details of the task.
     */
    @Override
    public String toString() {
        return "There is a task named" + this.name + "scheduled at" + this.time + "on" + this.date +
                "," + this.description;
    }
}
