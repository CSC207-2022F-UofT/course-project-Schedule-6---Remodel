package entity.Category;

public class CommonCategoryFactory implements CategoryFactory{
    @Override
    public Category create(String name, boolean status) {
        return new CommonCategory(name, status);
    }
}
