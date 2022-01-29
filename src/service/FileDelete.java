package service;

import java.io.*;
import java.util.ArrayList;

public class FileDelete extends FileManager {

  @Override
  public void fileOperation(String filepath) {
    ArrayList<ArrayList<String>> fileRecordArray = this.getFileRecordArray();
    String toDeleteLine = "";
    for (ArrayList<String> innerList : fileRecordArray) {
      for (String str : innerList) {
        // toDeleteLine.concat(str).concat("\t");
        toDeleteLine = str + "\t";
      }
    }

    try {
      File file = new File(filepath);
      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line = "", oldtext = "";
      while ((line = reader.readLine()) != null) {
        oldtext += line + "\r\n";
      }
      reader.close();

      // To replace a line in a file
      String newtext = oldtext.replaceAll(toDeleteLine, "");

      FileWriter writer = new FileWriter(filepath);
      writer.write(newtext);
      writer.close();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

}
