package repo.Recurring;

import java.util.ArrayList;
import java.util.Date;

import models.Category.Category;
import models.Transaction.Transaction;
import models.Transaction.TransactionData;
import models.Transaction.TransactionEntry;
import models.Transaction.TransactionEntryList;
import models.Transaction.TransactionList;

public class NoRecurring implements TransactionRecurringManager {

    @Override
    public TransactionEntryList getRecurringList(TransactionList transactionList) {
        ArrayList<Transaction> transactionArrayList = transactionList.getList();
        ArrayList<TransactionEntry> transactionEntryArrayList = new ArrayList<TransactionEntry>();

        for (Transaction transaction : transactionArrayList) {
            Date startingDate = transaction.getStartDate();
            Category category = transaction.getCategory();
            String note = transaction.getNote();
            double amount = transaction.getAmount();

            TransactionData transactionData = new TransactionData(category, note, amount);
            TransactionEntry transactionEntry = new TransactionEntry(startingDate, transactionData);

            transactionEntryArrayList.add(transactionEntry);
        }

        return new TransactionEntryList(transactionEntryArrayList);
    }

}
