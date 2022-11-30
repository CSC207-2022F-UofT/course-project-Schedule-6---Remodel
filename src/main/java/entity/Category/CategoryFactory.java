package entity.Category;

public interface CategoryFactory {
    Category create(String name, Boolean status);
}
