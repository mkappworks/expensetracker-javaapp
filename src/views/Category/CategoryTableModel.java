package views.Category;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import models.Category.Category;

public class CategoryTableModel extends AbstractTableModel {

    private String[] columnNames = { "id", "Title", "Transaction Type", "Budget" };
    private List<Category> listCategory = new ArrayList<>();

    public CategoryTableModel(List<Category> listCategory) {
        this.listCategory.addAll(listCategory);
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
        return listCategory.size();
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        Category category = listCategory.get(rowIndex);

        switch (columnIndex) {
            case 0:
                category.setId((int) value);
                break;
            case 1:
                category.setTitle((String) value);
                break;
            case 2:
                category.setTransactionType((String) value);
                break;
            case 3:
                category.setBudget((double) value);
                break;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object returnValue = null;
        Category category = listCategory.get(rowIndex);
        switch (columnIndex) {
            case 0:
                returnValue = category.getId();
                break;
            case 1:
                returnValue = category.getTitle();
                break;
            case 2:
                returnValue = category.getTransactionType();
                break;
            case 3:
                returnValue = category.getBudget();
                break;

        }
        return returnValue;
    }

    boolean[] canEdit = new boolean[] {
            false, false, false, false
    };

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
    }
}
