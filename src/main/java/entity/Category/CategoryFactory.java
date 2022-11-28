package entity.Category;

public interface CategoryFactory {
    Category create(String name, boolean status, String hex);
}
