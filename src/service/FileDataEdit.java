package service;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FileDataEdit extends FileManager {

    @Override
    public void fileOperation(String filepath) {
        try {
            File myObj = new File(filepath);
            Scanner myReader = new Scanner(myObj);
            String deleteLine = "02 food ";
            // ArrayList<String> fileRecordArray = new ArrayList<String>();
            String line = myReader.findInLine(deleteLine);
            System.out.println(line);
            // while (myReader.hasNextLine()) {
            // String record = myReader.nextLine();
            // System.out.println(record);

            // // if (record == deleteLine) {
            // String line = myReader.findInLine(deleteLine);
            // System.out.println(line);
            // // System.out.println("removed");

            // // }

            // }
            myReader.close();

            // ArrayList<ArrayList<String>> arrayList = this.getFileRecordArray();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
