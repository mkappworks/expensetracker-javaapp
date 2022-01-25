package models.Transaction;

import java.util.ArrayList;

public class TransactionList {

    private ArrayList<Transaction> list;

    public TransactionList(ArrayList<Transaction> list) {
        this.list = list;
    }

    public ArrayList<Transaction> getList() {
        return list;
    }

    public void setList(ArrayList<Transaction> list) {
        this.list = list;
    }
}
