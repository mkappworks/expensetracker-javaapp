package views.common;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import models.Category.Category;

public class CategoryCellRenderer extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof Category) {
            Category category = (Category) value;
            this.setText(category.getTitle());
        }

        if (isSelected) {
            setBackground(table.getSelectionBackground());
        } else {
            setBackground(table.getSelectionForeground());
        }

        return this;
    }

}