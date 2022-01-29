package controller.Transaction;

import models.Transaction.TransactionList;

public abstract class TransactionRepoManager {

    private TransactionList transactionList;

    public abstract void query();

    public TransactionList getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(TransactionList transactionList) {
        this.transactionList = transactionList;
    }
}
