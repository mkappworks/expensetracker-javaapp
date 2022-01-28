package repo.Transaction;

import models.Transaction.Transaction;
import models.Transaction.TransactionList;
import java.text.SimpleDateFormat;
import java.util.Date;
import service.FileDataAdd;
import service.FileManager;

import java.util.ArrayList;

public class TransactionRepoAdd extends TransactionRepoManager {

  public void query(Transaction transaction) {
    SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");

    // get transaction list

    ArrayList<ArrayList<String>> aList = new ArrayList<ArrayList<String>>();

    ArrayList<String> stringArray = new ArrayList<String>();
    String id = Integer.toString(transaction.getId());

    Date date = transaction.getStartDate();
    String startingDate = DateFor.format(date);

    String note = transaction.getNote();
    String recurringType = transaction.getRecurringType();
    String additionalRecurringAmount = Integer.toString(transaction.getAdditionalRecurringAmount());
    String amount = Double.toString(transaction.getAmount());

    stringArray.add(id);
    stringArray.add(startingDate);
    stringArray.add(note);
    stringArray.add(recurringType);
    stringArray.add(additionalRecurringAmount);
    stringArray.add(amount);

    aList.add(stringArray);

    FileManager fileAdd = new FileDataAdd();
    fileAdd.setFileRecordArray(aList);
    fileAdd.fileOperation("category.txt");
  }

  @Override
  public void query() {
    throw new UnsupportedOperationException();

  }
}
