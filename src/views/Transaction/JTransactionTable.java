package views.Transaction;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumn;

import controller.Category.CategoryRepoGet;
import controller.Category.CategoryRepoManager;
import controller.Transaction.TransactionRepoAmend;
import controller.Transaction.TransactionRepoGet;
import controller.Transaction.TransactionRepoManager;
import models.Category.Category;
import models.Transaction.Transaction;
import models.Transaction.TransactionList;

public class JTransactionTable extends JTable {

    private JTable table = new JTable();
    private JScrollPane scrollpane = new JScrollPane();
    private TransactionTableModel tableModel;

    public JTransactionTable() {
        initComponents();
    }

    private void initComponents() {
        tableModel = new TransactionTableModel(getTransactionListData());
        table.setModel(tableModel);

        table.setDefaultRenderer(Category.class, new CategoryCellRenderer());
        table.setDefaultEditor(Category.class, new CategoryCellEditor(getCategoryListData()));

        TableColumn testColumn = table.getColumnModel().getColumn(4);
        JComboBox<String> jComboBoxRecurringType = new JComboBox<String>();
        jComboBoxRecurringType.setModel(new DefaultComboBoxModel<>(
                new String[] { "no", "daily", "monthly" }));
        testColumn.setCellEditor(new DefaultCellEditor(jComboBoxRecurringType));

        table.setBounds(new java.awt.Rectangle(0, 20, 450, 64));
        table.setColumnSelectionAllowed(true);
        table.setRowSelectionAllowed(true);
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

    private List<Transaction> getTransactionListData() {
        TransactionRepoManager transactionRepoGet = new TransactionRepoGet();
        transactionRepoGet.query();
        List<Transaction> listTransaction = new ArrayList<>();
        listTransaction = transactionRepoGet.getTransactionList().getList();
        return listTransaction;
    }

    private List<Category> getCategoryListData() {
        CategoryRepoManager categoryRepoGet = new CategoryRepoGet();
        categoryRepoGet.query();
        List<Category> listCategory = new ArrayList<>();
        listCategory = categoryRepoGet.getCategoryList().getList();
        return listCategory;
    }

    public void updateTransactionListData() {
        tableModel = new TransactionTableModel(getTransactionListData());
        table.setModel(tableModel);
    }

    public void saveEditTransactionRecords() {

        ArrayList<Transaction> listTransaction = new ArrayList<Transaction>(tableModel.getTransactionList());

        TransactionRepoManager transactionRepoAmend = new TransactionRepoAmend();
        transactionRepoAmend.setTransactionList(new TransactionList(listTransaction));
        transactionRepoAmend.query();
        updateTransactionListData();

        JOptionPane.showMessageDialog(null, "Edits Saved");
    }

    public void deleteTransactionRecords() {
        int selectRow = table.getSelectedRow();

        if (selectRow != -1) {
            ArrayList<Transaction> listTransaction = new ArrayList<Transaction>(tableModel.getTransactionList());
            listTransaction.remove(selectRow);

            TransactionRepoManager transactionRepoDelete = new TransactionRepoAmend();
            transactionRepoDelete.setTransactionList(new TransactionList(listTransaction));
            transactionRepoDelete.query();
            updateTransactionListData();

            JOptionPane.showMessageDialog(null, "Rows Deleted");
        } else {
            JOptionPane.showMessageDialog(null, "Unable To Delete");
        }

    }

}
