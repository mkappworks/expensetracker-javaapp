package controller.Tracker;

import java.util.ArrayList;

import models.Category.Category;
import models.Category.CategoryList;
import models.Tracker.CategoryTrackerData;
import models.Tracker.CategoryTrackerDataList;
import models.Transaction.TransactionEntry;
import models.Transaction.TransactionEntryList;

public class TrackerDataManager {

    private CategoryTrackerDataList ctdList;

    public void getCtdList(TransactionEntryList transactionEntryList, CategoryList categoryList) {

        ArrayList<TransactionEntry> transactionEntries = transactionEntryList.getList();
        ArrayList<Category> categories = categoryList.getList();
        ArrayList<CategoryTrackerData> categoryTrackerDatas = new ArrayList<CategoryTrackerData>();

        for (Category category : categories) {
            double amount = 0.0;

            for (TransactionEntry transactionEntry : transactionEntries) {
                if (transactionEntry.getTransactionData().getCategory().equals(category)) {
                    amount += transactionEntry.getTransactionData().getAmount();
                }
            }

            CategoryTrackerData categoryTrackerData = new CategoryTrackerData(category, amount);
            categoryTrackerDatas.add(categoryTrackerData);
        }

        this.setCtdList(new CategoryTrackerDataList(categoryTrackerDatas));

    }

    public CategoryTrackerDataList getCtdList() {
        return ctdList;
    }

    public void setCtdList(CategoryTrackerDataList ctdList) {
        this.ctdList = ctdList;
    }
}
