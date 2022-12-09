package entity.Task;

/**
 * Interface that CommonTask implements
 */
public interface Task {

    String getDescription();

    String getDate();

    String getCategory();

    void setDescription(String newDescription);

    void setDate(String newDate);

    void setCategory(String newCategory);
}
