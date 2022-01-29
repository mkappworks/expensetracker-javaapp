package service;

import java.util.ArrayList;

abstract public class FileManager {

    private ArrayList<ArrayList<String>> fileRecordArray;

    public abstract void fileOperation(String filePath);

    public ArrayList<ArrayList<String>> getFileRecordArray() {
        return fileRecordArray;
    }

    public void setFileRecordArray(ArrayList<ArrayList<String>> fileRecordArray) {
        this.fileRecordArray = fileRecordArray;
    }
}
