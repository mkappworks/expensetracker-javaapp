package models.Transaction;

import java.util.Date;

public class TransactionEntry {

    private int id;
    private Date date;
    private TransactionData transactionData;

    public TransactionEntry(int id, Date date, TransactionData transactionData) {
        this.id = id;
        this.date = date;
        this.transactionData = transactionData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TransactionData getTransactionData() {
        return transactionData;
    }

    public void setTransactionData(TransactionData transactionData) {
        this.transactionData = transactionData;
    }

}
