package repo.Recurring;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import models.Category.Category;
import models.Transaction.Transaction;
import models.Transaction.TransactionData;
import models.Transaction.TransactionEntry;
import models.Transaction.TransactionEntryList;
import models.Transaction.TransactionList;

public class MonthlyRecurring implements TransactionRecurringManager {

    @Override
    public TransactionEntryList getRecurringList(TransactionList transactionList) {
        ArrayList<Transaction> transactionArrayList = transactionList.getList();
        ArrayList<TransactionEntry> transactionEntryArrayList = new ArrayList<TransactionEntry>();

        for (Transaction transaction : transactionArrayList) {
            Date startingDate = transaction.getStartDate();
            Category category = transaction.getCategory();
            String note = transaction.getNote();
            int additionalRecurringAmount = transaction.getAdditionalRecurringAmount();
            double amount = transaction.getAmount();
            TransactionData transactionData = new TransactionData(category, note, amount);

            for (int i = 0; i <= additionalRecurringAmount; i++) {
                Date date = startingDate;
                Calendar calender = Calendar.getInstance();
                calender.setTime(startingDate);
                calender.add(Calendar.MONTH, i);
                date = calender.getTime();

                TransactionEntry transactionEntry = new TransactionEntry(date, transactionData);
                transactionEntryArrayList.add(transactionEntry);
            }

        }

        return new TransactionEntryList(transactionEntryArrayList);
    }

}
