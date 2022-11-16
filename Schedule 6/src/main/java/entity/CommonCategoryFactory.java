package entity;

public class CommonCategoryFactory implements CategoryFactory{
    @Override
    public Category create(String name, boolean status, String hex) {
        return new CommonCategory(name, status, hex);
    }
}
