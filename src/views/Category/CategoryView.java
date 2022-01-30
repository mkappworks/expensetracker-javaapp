package views.Category;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import controller.Category.CategoryRepoAdd;
import controller.Category.CategoryRepoGet;
import controller.Category.CategoryRepoManager;
import models.Category.Category;
import models.Category.CategoryList;
import utils.TypeCheck;
import views.MainView;

public class CategoryView extends javax.swing.JFrame {

    // Variables declaration - do not modify
    private JButton jButtonAddNew;
    private JComboBox<String> jComboBoxTransactionType;
    private JLabel jLabelBudget;
    private JLabel jLabelId;
    private JLabel jLabelTitle;
    private JLabel jLabelTransactionType;
    private JScrollPane jScrollPaneCategory;
    private JTextField jTextFieldBudget;
    private JTextField jTextId;
    private JTextField jTextTitle;

    String[] columnTitles = { "id", "Title", "Transaction Type", "Budget" };
    DefaultTableModel tableModel = new DefaultTableModel(columnTitles,
            0) {
        Class[] types = new Class[] {
                String.class, String.class, String.class, String.class
        };
        boolean[] canEdit = new boolean[] {
                false, false, false, false
        };

        public Class getColumnClass(int columnIndex) {
            return types[columnIndex];
        }

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit[columnIndex];
        };
    };

    private JTable jTableCategory = new JTable(tableModel);
    // End of variables declaration

    public CategoryView() {
        initComponents();
    }

    public static void main() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CategoryView().setVisible(true);
            }
        });
    }

    private void initComponents() {
        jLabelId = new JLabel();
        jTextId = new JTextField();
        jComboBoxTransactionType = new JComboBox<>();
        jLabelTitle = new JLabel();
        jScrollPaneCategory = new JScrollPane();
        jLabelTransactionType = new JLabel();
        jTextTitle = new JTextField();
        jLabelBudget = new JLabel();
        jTextFieldBudget = new JTextField();
        jButtonAddNew = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabelId.setText("id");

        jComboBoxTransactionType.setModel(new DefaultComboBoxModel<>(new String[] { "income", "expense" }));

        jLabelTitle.setText("Title");

        setCategoryTableData();

        jTableCategory.setBounds(new Rectangle(0, 20, 450, 64));
        jTableCategory.setColumnSelectionAllowed(true);
        jTableCategory.getTableHeader().setResizingAllowed(false);
        jTableCategory.getTableHeader().setReorderingAllowed(false);
        jScrollPaneCategory.setViewportView(jTableCategory);
        jTableCategory.getColumnModel().getSelectionModel()
                .setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jLabelTransactionType.setText("Transaction Type");

        jLabelBudget.setText("Budget");

        jButtonAddNew.setText("Add Category");
        jButtonAddNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonAddNewActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addGroup(layout
                                                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabelId)
                                                        .addComponent(jLabelTitle)
                                                        .addComponent(jLabelTransactionType)
                                                        .addComponent(jLabelBudget))
                                                .addGap(37, 37, 37)
                                                .addGroup(layout
                                                        .createParallelGroup(GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(jTextId)
                                                        .addComponent(jTextTitle)
                                                        .addComponent(jComboBoxTransactionType, 0, 132, Short.MAX_VALUE)
                                                        .addComponent(jTextFieldBudget)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(91, 91, 91)
                                                .addComponent(jButtonAddNew, GroupLayout.PREFERRED_SIZE,
                                                        120, GroupLayout.PREFERRED_SIZE)))
                                .addGap(40, 40, 40)
                                .addComponent(jScrollPaneCategory, GroupLayout.DEFAULT_SIZE, 404,
                                        Short.MAX_VALUE)
                                .addGap(19, 19, 19)));

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelId)
                                        .addComponent(jTextId, GroupLayout.PREFERRED_SIZE, 40,
                                                GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextTitle, GroupLayout.PREFERRED_SIZE, 40,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelTitle))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelTransactionType)
                                        .addComponent(jComboBoxTransactionType, GroupLayout.PREFERRED_SIZE,
                                                40, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelBudget)
                                                .addGap(12, 12, 12))
                                        .addComponent(jTextFieldBudget, GroupLayout.PREFERRED_SIZE, 40,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGap(65, 65, 65)
                                .addComponent(jButtonAddNew, GroupLayout.PREFERRED_SIZE, 50,
                                        GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(37, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPaneCategory, GroupLayout.PREFERRED_SIZE, 350,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)));

        pack();
    }

    private void formWindowClosed(java.awt.event.WindowEvent evt) {
        MainView.main();
    }

    private void setTextFieldBorderColor() {
        Border border = BorderFactory.createLineBorder(Color.WHITE);
        jTextId.setBorder(border);
        jTextTitle.setBorder(border);
        jTextFieldBudget.setBorder(border);
    }

    private boolean isTextFieldDataValid() {
        TypeCheck typeCheck = new TypeCheck();
        Border border = BorderFactory.createLineBorder(Color.RED);

        if (!typeCheck.isInt(jTextId.getText())) {
            jTextId.setBorder(border);
            JOptionPane.showMessageDialog(new JFrame(), "Please Enter a Numeric Id");
            return false;
        }

        if (typeCheck.isEmpty(jTextTitle.getText())) {
            jTextTitle.setBorder(border);
            JOptionPane.showMessageDialog(new JFrame(), "Please Enter a Category Title");
            return false;
        }

        if (!typeCheck.isDouble(jTextFieldBudget.getText())) {
            jTextFieldBudget.setBorder(border);
            JOptionPane.showMessageDialog(new JFrame(), "Please Enter a Numeric Budget");
            return false;
        }

        return true;
    }

    private void setCategoryTableData() {

        tableModel.setRowCount(0);

        CategoryRepoManager categoryRepoGet = new CategoryRepoGet();
        categoryRepoGet.query();
        ArrayList<Category> categoryArray = categoryRepoGet.getCategoryList().getList();

        if (categoryArray.isEmpty())
            return;

        for (Category category : categoryArray) {
            Object[] rowData = new Object[] { category.getId(), category.getTitle(), category.getTransactionType(),
                    category.getBudget() };
            tableModel.addRow(rowData);

        }
    }

    private void jButtonAddNewActionPerformed(ActionEvent evt) {
        setTextFieldBorderColor();

        if (!isTextFieldDataValid())
            return;

        int id = Integer.parseInt(jTextId.getText());
        String title = jTextTitle.getText();
        String transactionType = jComboBoxTransactionType.getSelectedItem().toString();
        double budget = Double.parseDouble(jTextFieldBudget.getText());

        Category category = new Category(id, title, budget, transactionType);
        ArrayList<Category> categoryArray = new ArrayList<Category>();
        categoryArray.add(category);
        CategoryList categoryList = new CategoryList(categoryArray);

        CategoryRepoManager categoryRepoAdd = new CategoryRepoAdd();
        categoryRepoAdd.setCategoryList(categoryList);
        categoryRepoAdd.query();

        setCategoryTableData();

        jTextId.setText("");
        jTextTitle.setText("");
        jComboBoxTransactionType.setSelectedIndex(0);
        jTextFieldBudget.setText("");
    }

}
