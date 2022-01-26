package repo.Category;

import models.Category.CategoryList;

public abstract class CategoryRepoManager {

    private CategoryList categoryList;

    public abstract void query();

    public CategoryList getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(CategoryList categoryList) {
        this.categoryList = categoryList;
    }

}
