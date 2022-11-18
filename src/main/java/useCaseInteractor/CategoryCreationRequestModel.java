package useCaseInteractor;

public class CategoryCreationRequestModel {
    private String name;
    private boolean status;
    private String hex;


    public CategoryCreationRequestModel(String name, boolean status, String hex) {
        this.name = name;
        this.status = status;
        this.hex = hex;
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

    String getHex() {
        return hex;
    }

    void setHex() {
        this.hex = hex;
    }






}
