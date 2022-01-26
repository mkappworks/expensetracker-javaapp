package service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileDataGet extends FileManager {

    @Override
    public void fileOperation(String filepath) {
        try {

            File myObj = new File(filepath);
            Scanner myReader = new Scanner(myObj);
            ArrayList<ArrayList<String>> fileRecordArray = new ArrayList<ArrayList<String>>();
            while (myReader.hasNextLine()) {
                String record = myReader.nextLine();
                String recordString[] = record.split(" ");

                ArrayList<String> stringList = new ArrayList<String>(
                        Arrays.asList(recordString));

                fileRecordArray.add(stringList);
            }
            myReader.close();

            this.setFileRecordArray(fileRecordArray);
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

}
