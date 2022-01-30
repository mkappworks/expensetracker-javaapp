package views.Category;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import controller.Category.CategoryRepoGet;
import controller.Category.CategoryRepoManager;

import models.Category.Category;

public class JCategoryTable extends JTable {

    private JTable table = new JTable();
    private JScrollPane scrollpane = new JScrollPane();
    private CategoryTableModel tableModel;

    public JCategoryTable() {
        initComponents();

    }

    private void initComponents() {
        tableModel = new CategoryTableModel(getCategoryListData());
        table.setModel(tableModel);
        table.setBounds(new java.awt.Rectangle(0, 20, 450, 64));
        table.setColumnSelectionAllowed(true);
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.getColumnModel().getSelectionModel()
                .setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        scrollpane = new JScrollPane(table);
        scrollpane.setPreferredSize(new Dimension(400, 200));
        add(scrollpane, BorderLayout.CENTER);
        setVisible(true);
    }

    public JScrollPane getScrollPane() {
        return this.scrollpane;
    }

    private List<Category> getCategoryListData() {
        CategoryRepoManager categoryRepoGet = new CategoryRepoGet();
        categoryRepoGet.query();
        List<Category> listCategory = new ArrayList<>();
        listCategory = categoryRepoGet.getCategoryList().getList();
        return listCategory;
    }

    public void updateTransactionListData() {
        tableModel = new CategoryTableModel(getCategoryListData());
        table.setModel(tableModel);
    }

}
