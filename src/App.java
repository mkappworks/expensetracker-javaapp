import repo.Category.CategoryRepoGet;
import repo.Category.CategoryRepoManager;
import views.CategoryGUI;
import java.util.ArrayList;


public class App {
    public static void main(String[] args) throws Exception {
        CategoryGUI categoryGUI = new CategoryGUI();
        categoryGUI.initialise();

        ArrayList<ArrayList<String>> aList = new ArrayList<ArrayList<String>>(1);
        ArrayList<String> al = new ArrayList<String>();
        al.add("Id 01");
        al.add("Category 01");
        al.add("1000");

        aList.add(al);
        ArrayList<String> a2 = new ArrayList<String>();

        a2.add("Id 02");
        a2.add("Category 02");
        a2.add("2000");
        aList.add(a2);

        service.FileManager fileadd = new FileDataAdd();
        fileadd.setFileRecordArray(aList);
        fileadd.fileOperation("transaction.txt");
    }
}
