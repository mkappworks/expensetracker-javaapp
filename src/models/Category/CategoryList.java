package models.Category;

import java.util.ArrayList;

public class CategoryList {

    private ArrayList<Category> list;

    public CategoryList(ArrayList<Category> list) {
        this.list = list;
    }

    public ArrayList<Category> getList() {
        return list;
    }

    public void setList(ArrayList<Category> list) {
        this.list = list;
    }
}
