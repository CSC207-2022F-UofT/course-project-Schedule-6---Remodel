package useCaseInteractor.Task;

import entity.Category.Category;
import entity.Task.CommonTask;

import java.time.LocalDate;

public class EditTask extends CommonTask {

    public EditTask(String title, LocalDate date, String privacySetting, Category category) {
        super(title, date, privacySetting, category);
    }


    public void editTask (String newTitle, LocalDate newDate, String newPrivacySetting, Category newCategory){
        super.title = newTitle;
        super.date = newDate;
        super.privacySetting = newPrivacySetting;
        super.category = newCategory;
    }
}
