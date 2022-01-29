import service.FileManager;
import java.util.ArrayList;

import service.FileDataAdd;
import service.FileDataAmend;
import views.CategoryGUI;

public class App {
    public static void main(String[] args) throws Exception {
        // CategoryGUI categoryGUI = new CategoryGUI();
        // categoryGUI.initialise();

        FileManager fileAmend = new FileDataAmend();
        ArrayList<ArrayList<String>> aList = new ArrayList<ArrayList<String>>(1);
        ArrayList<String> al = new ArrayList<String>();
        al.add("02");
        al.add("rent");
        al.add("1500");

        aList.add(al);

        // fileDelete.setFileRecordArray(aList);
        fileAmend.setFileRecordArray(aList);
        fileAmend.fileOperation("test.txt");

        // FileManager fileAdd = new FileDataAdd();
        // fileAdd.setFileRecordArray(aList);
        // fileAdd.fileOperation("test.txt");
    }
}
