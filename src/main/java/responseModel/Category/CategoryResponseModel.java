package responseModel.Category;

<<<<<<< HEAD
public class CategoryCreationResponseModel {
    String name;
    boolean status;

    public CategoryCreationResponseModel (String name, boolean status) {
=======
public class CategoryResponseModel {
    String name;
    boolean status;

    public CategoryResponseModel(String name, boolean status) {
>>>>>>> origin/feature-8-user
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
