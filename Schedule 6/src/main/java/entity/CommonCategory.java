package entity;
//new entity
public class CommonCategory implements Category {
    private final String name;
    private final boolean status;
    private final String hex;


    public CommonCategory(String name, boolean status, String hex) {
        this.name = name;
        this.status = status;
        this.hex = hex;
    }

    public String getName() {
        return name;
    }

    public boolean isStatus() {
        return status;
    }

    public String getHex() {
        return hex;
    }
}
