package entity;
import java.util.ArrayList;

public class ToDoList {
    private ArrayList<Task> tasks;
    private ArrayList<CommonCategory> categories;

    public void ToDo(){
        this.tasks = new ArrayList<>();
        this.categories = new ArrayList<>();
    }

    public void addTask(String title, String date, String time, String description){
//        this.tasks.add(new Task(title, date, time, description));
    }

    public void deleteTask(Task t){
        this.tasks.remove(t);
    }

    public void addCategory(String name, boolean status, String hex){
        this.categories.add(new CommonCategory(name, status, hex));
    }

    public void deleteCategory(Category category){
        this.categories.remove(category);
    }

    public ArrayList<Task> getTasks(){
        return this.tasks;
    }

    public ArrayList<CommonCategory> getCategories(){
        return this.categories;
    }

}
