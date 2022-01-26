
import repo.Category.CategoryRepoGet;
import repo.Category.CategoryRepoManager;
import service.FileDataGet;
import views.CategoryGUI;

public class App {
    public static void main(String[] args) throws Exception {
        // CategoryGUI categoryGUI = new CategoryGUI();
        // categoryGUI.initialise();
        CategoryRepoManager categoryRepoGet = new CategoryRepoGet();
        categoryRepoGet.query();
        System.out.println(categoryRepoGet.getCategoryList());
    }
}
