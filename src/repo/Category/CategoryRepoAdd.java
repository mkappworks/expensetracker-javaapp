package repo.Category;

import java.util.ArrayList;
import models.Category.Category;
import service.FileDataAdd;
import service.FileManager;

public class CategoryRepoAdd extends CategoryRepoManager {

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

    FileManager fileAdd = new FileDataAdd();
    fileAdd.setFileRecordArray(fileRecordArray);
    fileAdd.fileOperation("category.txt");
  }

}
