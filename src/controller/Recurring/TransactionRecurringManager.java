package controller.Recurring;

import models.Transaction.TransactionEntryList;
import models.Transaction.TransactionList;

public interface TransactionRecurringManager {

    public TransactionEntryList getRecurringList(TransactionList transactionList);

}
