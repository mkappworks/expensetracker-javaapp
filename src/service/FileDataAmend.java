package service;

import java.io.*;

public class FileDataAmend extends FileManager {

  @Override
  public void fileOperation(String filepath) {

    File file = new File(filepath);
    file.delete();
  }
}
