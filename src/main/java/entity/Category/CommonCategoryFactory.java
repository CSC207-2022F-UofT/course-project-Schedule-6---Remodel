package entity.Category;

public class CommonCategoryFactory implements CategoryFactory{
    @Override
    public Category create(String name, Boolean status) {
        return new CommonCategory(name, status);
    }
}
