package views.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import models.Category.Category;
import models.Transaction.Transaction;

public class TransactionTableModel extends AbstractTableModel {

    private String[] columnNames = { "id", "Start Date", "Category", "Note", "Recurring Type", "Recurring Amount",
            "Amount" };
    private List<Transaction> listTransaction = new ArrayList<>();

    public TransactionTableModel(List<Transaction> listTransaction) {
        this.listTransaction.addAll(listTransaction);
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int column) {
        return columnNames[column];
    }

    public Class getColumnClass(int column) {
        return getValueAt(0, column).getClass();
    }

    @Override
    public int getRowCount() {
        return listTransaction.size();
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        Transaction transaction = listTransaction.get(rowIndex);

        switch (columnIndex) {
            case 0:
                transaction.setId((int) value);
                break;
            case 1:
                transaction.setStartDate((Date) value);
                break;
            case 2:
                transaction.setCategory((Category) value);
                break;
            case 3:
                transaction.setNote((String) value);
                break;
            case 4:
                transaction.setRecurringType((String) value);
                break;
            case 5:
                transaction.setAdditionalRecurringAmount((int) value);
                break;
            case 6:
                transaction.setAmount((double) value);
                break;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object returnValue = null;
        Transaction transaction = listTransaction.get(rowIndex);
        switch (columnIndex) {
            case 0:
                returnValue = transaction.getId();
                break;
            case 1:
                returnValue = transaction.getStartDate();
                break;
            case 2:
                returnValue = transaction.getCategory();
                break;
            case 3:
                returnValue = transaction.getNote();
                break;
            case 4:
                returnValue = transaction.getRecurringType();
                break;
            case 5:
                returnValue = transaction.getAdditionalRecurringAmount();
                break;
            case 6:
                returnValue = transaction.getAmount();
                break;

        }
        return returnValue;
    }

    boolean[] canEdit = new boolean[] {
            false, true, true, true, true, true, true
    };

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
    }
}
