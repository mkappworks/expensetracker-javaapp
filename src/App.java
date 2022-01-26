
import service.FileDataGet;
import service.FileDataAdd;
import views.CategoryGUI;
import java.util.ArrayList;


public class App {
    public static void main(String[] args) throws Exception {
        // CategoryGUI categoryGUI = new CategoryGUI();
        // categoryGUI.initialise();
        service.FileManager fileget = new FileDataGet();
        fileget.fileOperation("transaction.txt");
        System.out.println(fileget.getFileRecordArray());

        
        ArrayList<ArrayList<String> > aList = 
        new ArrayList<ArrayList<String> >(1);
        ArrayList<String> al=new ArrayList<String>();  
        al.add("Mango");  
        al.add("Apple"); 
        aList.add(al);
        ArrayList<String> al2=new ArrayList<String>();  
        al2.add("Banana");  
        al2.add("Grapes"); 
        aList.add(al2);


        service.FileManager fileadd = new FileDataAdd();
        fileadd.setFileRecordArray(aList);
        fileadd.fileOperation("transaction.txt");
    }
}
