package repo.Transaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import models.Category.Category;
import models.Transaction.Transaction;
import models.Transaction.TransactionList;
import service.FileDataGet;
import service.FileManager;

public class TransactionRepoGet extends TransactionRepoManager {

    @Override
    public void query() {
        FileManager fileGet = new FileDataGet();
        fileGet.fileOperation("transaction.txt");
        ArrayList<ArrayList<String>> fileRecordArray = fileGet.getFileRecordArray();
        ArrayList<Transaction> transactionArray = new ArrayList<Transaction>();

        for (ArrayList<String> record : fileRecordArray) {
            int id = Integer.parseInt(record.get(0));
            Date startDate = new Date();
            try {
                startDate = new SimpleDateFormat("dd/MM/yyyy").parse(record.get(1));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            int categoryid = Integer.parseInt(record.get(2));
            String categorytitle = record.get(3);
            double categorybudget = Double.parseDouble(record.get(4));
            String categoryTransactionType = record.get(5);
            String note = record.get(6);
            String recurringType = record.get(7);
            int additionalRecurringAmount = Integer.parseInt(record.get(8));
            double amount = Double.parseDouble(record.get(9));

            Category category = new Category(categoryid, categorytitle, categorybudget, categoryTransactionType);
            Transaction transaction = new Transaction(id, startDate, category, note, recurringType,
                    additionalRecurringAmount, amount);

            transactionArray.add(transaction);

        }

        this.setTransactionList(new TransactionList(transactionArray));

    }

}
