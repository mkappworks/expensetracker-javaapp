package models.Transaction;

import java.util.ArrayList;

public class TransactionEntryList {

    private ArrayList<TransactionEntry> list;

    public TransactionEntryList(ArrayList<TransactionEntry> list) {
        this.list = list;
    }

    public ArrayList<TransactionEntry> getList() {
        return list;
    }

    public void setList(ArrayList<TransactionEntry> list) {
        this.list = list;
    }

}
