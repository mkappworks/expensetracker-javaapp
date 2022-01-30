package views.Tracker;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import models.Category.Category;
import models.Tracker.TrackerData;

public class TrackerTableModel extends AbstractTableModel {

    private String[] columnNames = { "Category Id", "Category Title", "Category Transaction Type", "Category Budget",
            "Amount" };
    private List<TrackerData> listTrackerData = new ArrayList<>();

    public TrackerTableModel(List<TrackerData> listTrackerData) {
        this.listTrackerData.addAll(listTrackerData);
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
        return listTrackerData.size();
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        TrackerData trackerData = listTrackerData.get(rowIndex);

        switch (columnIndex) {
            case 0:
                trackerData.getCategory().setId((int) value);
                break;
            case 1:
                trackerData.getCategory().setTitle((String) value);
                break;
            case 2:
                trackerData.getCategory().setTransactionType((String) value);
                break;
            case 3:
                trackerData.getCategory().setBudget((double) value);
                break;
            case 4:
                trackerData.setAmount((double) value);
                break;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object returnValue = null;
        TrackerData trackerData = listTrackerData.get(rowIndex);
        switch (columnIndex) {
            case 0:
                returnValue = trackerData.getCategory().getId();
                break;
            case 1:
                returnValue = trackerData.getCategory().getTitle();
                break;
            case 2:
                returnValue = trackerData.getCategory().getTransactionType();
                break;
            case 3:
                returnValue = trackerData.getCategory().getBudget();
                break;
            case 4:
                returnValue = trackerData.getAmount();
                break;

        }
        return returnValue;
    }

    boolean[] canEdit = new boolean[] {
            false, false, false, false, false
    };

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
    }
}
