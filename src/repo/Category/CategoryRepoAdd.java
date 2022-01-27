package repo.Category;

import java.util.ArrayList;
import models.Category.Category;
import models.Category.CategoryList;
import service.FileDataAdd;

public class CategoryRepoAdd extends CategoryRepoManager {

  @Override
  public void query() {

    // get category list
    CategoryList clObj = this.getCategoryList();
    ArrayList<Category> categoryArray = clObj.getList();

    ArrayList<ArrayList<String>> aList = new ArrayList<ArrayList<String>>();
    for (Category categoryObj : categoryArray) {
      ArrayList<String> stringArray = new ArrayList<String>();
      String id = Integer.toString(categoryObj.getId());
      String title = categoryObj.getTitle();
      String budget = Double.toString(categoryObj.getBudget());
      stringArray.add(id);
      stringArray.add(title);
      stringArray.add(budget);

      aList.add(stringArray);
    }

    service.FileManager fileAdd = new FileDataAdd();
    fileAdd.setFileRecordArray(aList);
    fileAdd.fileOperation("category.txt");
  }
}
