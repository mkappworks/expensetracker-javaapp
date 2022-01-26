package service;
import java.io.FileWriter;  
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;  // Import the File class



public class FileDataAdd extends FileManager{


  public void fileOperation(String filePath){
    ArrayList<ArrayList<String>> fileRecordArray = this.getFileRecordArray();
    try
   {
    FileWriter fw = new FileWriter(filePath,true); //the true will append the new data
    for(ArrayList<String> innerList : fileRecordArray) {
      for(String str : innerList) {
          System.out.println(str);
          fw.write(str);     

      }
    }
   
          fw.close();
  }
  catch(IOException ioe)
  {
      System.err.println("IOException: " + ioe.getMessage());
  }
    }
  }
