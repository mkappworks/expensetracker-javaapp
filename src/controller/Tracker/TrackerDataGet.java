package controller.Tracker;

import java.util.ArrayList;

import controller.Category.CategoryRepoGet;
import controller.Category.CategoryRepoManager;
import controller.Recurring.DailyRecurring;
import controller.Recurring.MonthlyRecurring;
import controller.Recurring.NoRecurring;
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

        ArrayList<Transaction> noRecurringTransactionList = new ArrayList<Transaction>();
        ArrayList<Transaction> dailyRecurringTransactionList = new ArrayList<Transaction>();
        ArrayList<Transaction> montlyRecurringTransactionList = new ArrayList<Transaction>();

        for (Transaction transaction : transactionList) {
            if (transaction.getRecurringType().equals("daily")) {
                dailyRecurringTransactionList.add(transaction);
            } else if (transaction.getRecurringType().equals("monthly")) {
                montlyRecurringTransactionList.add(transaction);
            } else {
                noRecurringTransactionList.add(transaction);
            }
        }

        TransactionRecurringManager noRecurringManager = new NoRecurring();
        TransactionEntryList noRecurringTransactionEntryList = noRecurringManager
                .getRecurringList(new TransactionList(noRecurringTransactionList));

        TransactionRecurringManager dailyRecurringManager = new DailyRecurring();
        TransactionEntryList dailyRecurringTransactionEntryList = dailyRecurringManager
                .getRecurringList(new TransactionList(dailyRecurringTransactionList));

        TransactionRecurringManager montlyRecurringManager = new MonthlyRecurring();
        TransactionEntryList montlyRecurringTransactionEntryList = montlyRecurringManager
                .getRecurringList(new TransactionList(montlyRecurringTransactionList));

        ArrayList<TransactionEntry> combinedTransactionEntry = new ArrayList<TransactionEntry>();
        combinedTransactionEntry.addAll(noRecurringTransactionEntryList.getList());
        combinedTransactionEntry.addAll(dailyRecurringTransactionEntryList.getList());
        combinedTransactionEntry.addAll(montlyRecurringTransactionEntryList.getList());

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
