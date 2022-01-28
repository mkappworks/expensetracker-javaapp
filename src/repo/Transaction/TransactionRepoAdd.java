package repo.Transaction;

import models.Transaction.Transaction;
import models.Transaction.TransactionList;
import java.text.SimpleDateFormat;
import java.util.Date;
import service.FileDataAdd;
import service.FileManager;

import java.util.ArrayList;

public class TransactionRepoAdd extends TransactionRepoManager {

  @Override
  public void query() {
    SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");

    // get transaction list
    TransactionList transactionListObj = this.getTransactionList();
    ArrayList<Transaction> transactionArray = transactionListObj.getList();
    ArrayList<ArrayList<String>> aList = new ArrayList<ArrayList<String>>();

    for (Transaction transactionObj : transactionArray) {
      ArrayList<String> stringArray = new ArrayList<String>();
      String id = Integer.toString(transactionObj.getId());

      Date date = transactionObj.getStartDate();
      String startingDate = DateFor.format(date);

      String note = transactionObj.getNote();
      String recurringType = transactionObj.getRecurringType();
      String additionalRecurringAmount = Integer.toString(transactionObj.getAdditionalRecurringAmount());
      String amount = Double.toString(transactionObj.getAmount());

      stringArray.add(id);
      stringArray.add(startingDate);
      stringArray.add(note);
      stringArray.add(recurringType);
      stringArray.add(additionalRecurringAmount);
      stringArray.add(amount);

      aList.add(stringArray);
    }
    FileManager fileAdd = new FileDataAdd();
    fileAdd.setFileRecordArray(aList);
    fileAdd.fileOperation("category.txt");
  }
}
