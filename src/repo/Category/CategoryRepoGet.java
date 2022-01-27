package repo.Category;

import java.util.ArrayList;
import models.Category.Category;
import models.Category.CategoryList;
import service.FileDataGet;

public class CategoryRepoGet extends CategoryRepoManager {

    @Override
    public void query() {
        service.FileManager fileGet = new FileDataGet();
        fileGet.fileOperation("category.txt");
        ArrayList<ArrayList<String>> fileRecordArray = fileGet.getFileRecordArray();
        ArrayList<Category> categoryArray = new ArrayList<Category>();

        for (ArrayList<String> record : fileRecordArray) {
            int id = Integer.parseInt(record.get(0));
            String title = record.get(1);
            double amount = Double.parseDouble(record.get(2));

            Category category = new Category(id, title, amount);
            categoryArray.add(category);

        }

        setCategoryList(new CategoryList(categoryArray));

    }

}
