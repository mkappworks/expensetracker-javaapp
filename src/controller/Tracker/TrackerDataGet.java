package controller.Tracker;

import java.util.ArrayList;

import controller.Category.CategoryRepoGet;
import controller.Category.CategoryRepoManager;
import controller.Recurring.AbstractFactory;
import controller.Recurring.RecurringFactory;
import controller.Recurring.TransactionRecurringManager;
import controller.Transaction.TransactionRepoGet;
import controller.Transaction.TransactionRepoManager;
import models.Category.Category;
import models.Tracker.TrackerData;
import models.Tracker.TrackerDataList;
import models.Transaction.Transaction;
import models.Transaction.TransactionEntry;
import models.Transaction.TransactionEntryList;
import models.Transaction.TransactionList;

public class TrackerDataGet extends TrackerDataManager {

    public void convertToCtdList() {

        TransactionRepoManager transactionRepoGet = new TransactionRepoGet();
        transactionRepoGet.query();
        ArrayList<Transaction> transactionList = transactionRepoGet.getTransactionList().getList();

        AbstractFactory recurringFactory = new RecurringFactory();
        ArrayList<TransactionEntry> combinedTransactionEntry = new ArrayList<TransactionEntry>();

        for (Transaction transaction : transactionList) {
            TransactionRecurringManager manager = recurringFactory
                    .getManager(transaction.getRecurringType());
            ArrayList<Transaction> listTransaction = new ArrayList<Transaction>();
            listTransaction.add(transaction);
            TransactionEntryList transactionEntryList = manager.getRecurringList(new TransactionList(listTransaction));
            combinedTransactionEntry.addAll(transactionEntryList.getList());
        }

        TransactionEntryList combinedTransactionEntryList = new TransactionEntryList(combinedTransactionEntry);

        /* Category */
        ArrayList<TrackerData> trackerDataList = new ArrayList<TrackerData>();

        CategoryRepoManager categoryRepoGet = new CategoryRepoGet();
        categoryRepoGet.query();
        ArrayList<Category> categories = categoryRepoGet.getCategoryList().getList();

        for (Category category : categories) {
            double amount = 0.0;

            for (TransactionEntry transactionEntry : combinedTransactionEntryList.getList()) {
                if (transactionEntry.getTransactionData().getCategory().getId() == (category.getId())) {
                    amount += transactionEntry.getTransactionData().getAmount();
                }
            }

            trackerDataList.add(new TrackerData(category, amount));
        }

        this.setTrackerDataList(new TrackerDataList(trackerDataList));

    }

}
