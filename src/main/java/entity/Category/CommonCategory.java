package entity.Category;
//new entity
public class CommonCategory implements Category {
    private final String name;
    private final boolean status;

    public CommonCategory(String name, boolean status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public boolean getStatus() {
        return status;
    }
}
