package requestModel;

public class CategoryCreationRequestModel {
    private String name;
    private boolean status;

    public CategoryCreationRequestModel(String name, boolean status) {
        this.name = name;
        this.status = status;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    boolean getStatus() {
        return status;
    }

    void setStatus(boolean status) {
        this.status = status;
    }
}
