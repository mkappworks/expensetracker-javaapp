package repo.Transaction;

import models.Transaction.Transaction;
import java.text.SimpleDateFormat;
import service.FileDataAdd;
import service.FileManager;

import java.util.ArrayList;

public class TransactionRepoAdd extends TransactionRepoManager {

  public void query() {
    ArrayList<ArrayList<String>> fileRecordArray = new ArrayList<ArrayList<String>>();
    ArrayList<Transaction> transactionArray = this.getTransactionList().getList();

    for (Transaction transaction : transactionArray) {
      ArrayList<String> stringArray = new ArrayList<String>();

      String id = Integer.toString(transaction.getId());
      String startingDate = new SimpleDateFormat("dd/MM/yyyy").format(transaction.getStartDate());
      String categoryid = Integer.toString(transaction.getCategory().getId());
      String categorytitle = transaction.getCategory().getTitle();
      String categorybudget = Double.toString(transaction.getCategory().getBudget());
      String categoryTransactionType = transaction.getCategory().getTransactionType();
      String note = transaction.getNote();
      String recurringType = transaction.getRecurringType();
      String additionalRecurringAmount = Integer.toString(transaction.getAdditionalRecurringAmount());
      String amount = Double.toString(transaction.getAmount());

      stringArray.add(id);
      stringArray.add(startingDate);
      stringArray.add(categoryid);
      stringArray.add(categorytitle);
      stringArray.add(categorybudget);
      stringArray.add(categoryTransactionType);
      stringArray.add(note);
      stringArray.add(recurringType);
      stringArray.add(additionalRecurringAmount);
      stringArray.add(amount);

      fileRecordArray.add(stringArray);
    }

    FileManager fileAdd = new FileDataAdd();
    fileAdd.setFileRecordArray(fileRecordArray);
    fileAdd.fileOperation("transaction.txt");
  }

}
