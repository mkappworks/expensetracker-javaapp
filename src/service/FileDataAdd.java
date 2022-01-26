package service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileDataAdd extends FileManager {

  public void fileOperation(String filePath) {
    ArrayList<ArrayList<String>> fileRecordArray = this.getFileRecordArray();
    try {
      FileWriter fw = new FileWriter(filePath, true); // the true will append the new data

      for (ArrayList<String> innerList : fileRecordArray) {
        for (String str : innerList) {
          fw.write(str);
          fw.write("\t");
        }
        fw.write("\n");
      }
      fw.close();
    } catch (IOException ioe) {
      System.err.println("IOException: " + ioe.getMessage());
    }
  }
}
