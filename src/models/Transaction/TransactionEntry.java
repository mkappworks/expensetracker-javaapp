package models.Transaction;

import java.util.Date;

public class TransactionEntry {

    private Date date;
    private TransactionData transactionData;

    public TransactionEntry(Date date, TransactionData transactionData) {
        this.date = date;
        this.transactionData = transactionData;
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
