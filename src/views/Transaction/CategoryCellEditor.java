package views.Transaction;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import models.Category.Category;

public class CategoryCellEditor extends AbstractCellEditor
        implements TableCellEditor, ActionListener {

    private Category category;
    private List<Category> listCategory;

    public CategoryCellEditor(List<Category> listCategory) {
        this.listCategory = listCategory;
    }

    @Override
    public Object getCellEditorValue() {
        return this.category;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        if (value instanceof Category) {
            this.category = (Category) value;
        }

        JComboBox<Category> comboCategory = new JComboBox<Category>();

        for (Category categoryRecord : listCategory) {
            comboCategory.addItem(categoryRecord);
        }

        comboCategory.setSelectedItem(category);
        comboCategory.addActionListener(this);

        if (isSelected) {
            comboCategory.setBackground(table.getSelectionBackground());
        } else {
            comboCategory.setBackground(table.getSelectionForeground());
        }

        return comboCategory;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JComboBox<Category> comboCategory = (JComboBox<Category>) event.getSource();
        this.category = (Category) comboCategory.getSelectedItem();
    }

}