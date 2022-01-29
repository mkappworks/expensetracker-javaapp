package controller.Recurring;

import models.Transaction.TransactionEntryList;
import models.Transaction.TransactionList;

interface TransactionRecurringManager {

    public TransactionEntryList getRecurringList(TransactionList transactionList);

}
