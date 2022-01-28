package repo.Category;

import java.util.ArrayList;
import models.Category.Category;
import models.Category.CategoryList;
import service.FileDataAdd;
import service.FileManager;

public class CategoryRepoAdd extends CategoryRepoManager {

  public void query(Category category) {

    ArrayList<ArrayList<String>> aList = new ArrayList<ArrayList<String>>();

    ArrayList<String> stringArray = new ArrayList<String>();
    String id = Integer.toString(category.getId());
    String title = category.getTitle();
    String budget = Double.toString(category.getBudget());
    stringArray.add(id);
    stringArray.add(title);
    stringArray.add(budget);

    aList.add(stringArray);

    FileManager fileAdd = new FileDataAdd();
    fileAdd.setFileRecordArray(aList);
    fileAdd.fileOperation("category.txt");
  }

  @Override
  public void query() {
    throw new UnsupportedOperationException();

  }
}
