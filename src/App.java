
import service.FileDataGet;
import views.CategoryGUI;

public class App {
    public static void main(String[] args) throws Exception {
        // CategoryGUI categoryGUI = new CategoryGUI();
        // categoryGUI.initialise();
        service.FileManager fileget = new FileDataGet();
        fileget.fileOperation("transaction.txt");
        System.out.println(fileget.getFileRecordArray());
    }
}
