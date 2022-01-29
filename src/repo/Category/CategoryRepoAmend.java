package repo.Category;

import java.util.ArrayList;

import models.Category.Category;
import service.FileDataAmend;
import service.FileManager;

public class CategoryRepoAmend extends CategoryRepoManager {

    @Override
    public void query() {
        ArrayList<ArrayList<String>> fileRecordArray = new ArrayList<ArrayList<String>>();
        ArrayList<Category> categoryArray = this.getCategoryList().getList();

        for (Category category : categoryArray) {
            ArrayList<String> stringArray = new ArrayList<String>();

            String id = Integer.toString(category.getId());
            String title = category.getTitle();
            String budget = Double.toString(category.getBudget());

            stringArray.add(id);
            stringArray.add(title);
            stringArray.add(budget);

            fileRecordArray.add(stringArray);
        }

        FileManager fileAmend = new FileDataAmend();
        fileAmend.setFileRecordArray(fileRecordArray);
        fileAmend.fileOperation("category.txt");

    }

}
