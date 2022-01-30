package views.Transaction;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

import controller.Category.CategoryRepoAdd;
import controller.Category.CategoryRepoGet;
import controller.Category.CategoryRepoManager;
import controller.Transaction.TransactionRepoAdd;
import controller.Transaction.TransactionRepoManager;
import models.Category.Category;
import models.Transaction.Transaction;
import models.Transaction.TransactionList;
import utils.TypeCheck;

import javax.swing.JComboBox;

import views.MainView;

public class TransactionView extends JFrame {

        // Variables declaration - do not modify
        private JButton jButtonAddNew;
        private JButton jButtonSaveAmend;
        private JComboBox<Category> jComboBoxCategory;
        private JComboBox<String> jComboBoxRecurringType;
        private JLabel jLabelAmount;
        private JLabel jLabelCategory;
        private JLabel jLabelId;
        private JLabel jLabelNote;
        private JLabel jLabelRecurringAmount;
        private JLabel jLabelRecurringType;
        private JLabel jLabelStartDate;
        private JTextField jTextFieldAmount;
        private JTextField jTextFieldNote;
        private JTextField jTextFieldRecurringAmount;
        private JTextField jTextId;
        private JTextField jTextStartDate;
        JScrollPane jScrollPaneTransaction;
        private JTransactionTable jTransactionTable;
        // End of variables declaration

        public TransactionView() {
                initComponents();
        }

        public static void main() {
                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new TransactionView().setVisible(true);
                        }
                });
        }

        private void initComponents() {

                jLabelStartDate = new JLabel();
                jLabelCategory = new JLabel();
                jTextStartDate = new JTextField();
                jLabelNote = new JLabel();
                jLabelId = new JLabel();
                jLabelRecurringType = new JLabel();
                jTextFieldNote = new JTextField();
                jTextId = new JTextField();
                jComboBoxRecurringType = new JComboBox<String>();
                jComboBoxCategory = new JComboBox<Category>();
                jLabelRecurringAmount = new JLabel();
                jTextFieldRecurringAmount = new JTextField();
                jLabelAmount = new JLabel();
                jTextFieldAmount = new JTextField();
                jButtonAddNew = new JButton();
                jButtonSaveAmend = new JButton();
                jTransactionTable = new JTransactionTable();
                jScrollPaneTransaction = jTransactionTable.getScrollPane();

                setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                addWindowListener(new java.awt.event.WindowAdapter() {
                        public void windowClosed(java.awt.event.WindowEvent evt) {
                                formWindowClosed(evt);
                        }
                });

                jLabelCategory.setText("Category");

                jLabelNote.setText("Note");

                jLabelId.setText("id");

                CategoryRepoManager categoryRepoGet = new CategoryRepoGet();
                categoryRepoGet.query();
                ArrayList<Category> categoryArray = categoryRepoGet.getCategoryList().getList();

                for (Category category : categoryArray) {
                        jComboBoxCategory.addItem(category);
                }

                jLabelStartDate.setText("Start Date");

                jButtonAddNew.setText("Add Transaction");
                jButtonAddNew.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButtonAddNewActionPerformed(evt);
                        }
                });

                jLabelRecurringType.setText("Recurring Type");

                jComboBoxRecurringType
                                .setModel(new DefaultComboBoxModel<>(
                                                new String[] { "no", "daily", "monthly" }));
                jComboBoxRecurringType.addItemListener(new java.awt.event.ItemListener() {
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                jComboBoxRecurringTypeItemStateChanged(evt);
                        }
                });

                jLabelRecurringAmount.setText("Recurring Amount");

                jTextFieldRecurringAmount.setText("0");
                jTextFieldRecurringAmount.setEnabled(false);

                jLabelAmount.setText("Amount");

                jButtonSaveAmend.setText("Save Amend");
                jButtonSaveAmend.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButtonSaveAmendActionPerformed(evt);
                        }
                });

                GroupLayout layout = new GroupLayout(getContentPane());
                getContentPane().setLayout(layout);

                layout.setHorizontalGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(30, 30, 30)
                                                                .addGroup(layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jLabelId,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                130,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabelRecurringType,
                                                                                                                                GroupLayout.Alignment.TRAILING,
                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(jLabelNote,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                130,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(jLabelCategory,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                130,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(jLabelStartDate,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                130,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                                                                .addComponent(jLabelRecurringAmount,
                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(jLabelAmount,
                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE))
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jTextFieldRecurringAmount)
                                                                                                                .addGroup(layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                GroupLayout.Alignment.TRAILING)
                                                                                                                                .addComponent(jComboBoxRecurringType,
                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                148,
                                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                GroupLayout.Alignment.LEADING,
                                                                                                                                                false)
                                                                                                                                                .addComponent(jTextId)
                                                                                                                                                .addComponent(jTextStartDate)
                                                                                                                                                .addComponent(jComboBoxCategory,
                                                                                                                                                                0,
                                                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                .addComponent(jTextFieldNote,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                150,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE)))
                                                                                                                .addComponent(jTextFieldAmount,
                                                                                                                                GroupLayout.Alignment.TRAILING))
                                                                                                .addGap(36, 36, 36)))
                                                                .addComponent(jScrollPaneTransaction,
                                                                                GroupLayout.PREFERRED_SIZE, 564,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addGap(21, 21, 21))
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(83, 83, 83)
                                                                .addComponent(jButtonAddNew, GroupLayout.PREFERRED_SIZE,
                                                                                120,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jButtonSaveAmend,
                                                                                GroupLayout.PREFERRED_SIZE, 120,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addGap(223, 223, 223)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(36, 36, 36)
                                                                .addGroup(layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jScrollPaneTransaction,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                350,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(jTextId,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                40,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jLabelId))
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(jTextStartDate,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                40,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jLabelStartDate))
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(jComboBoxCategory,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                40,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jLabelCategory))
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(jTextFieldNote,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                40,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jLabelNote))
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(jComboBoxRecurringType,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                40,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jLabelRecurringType))
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(jTextFieldRecurringAmount,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                40,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jLabelRecurringAmount))
                                                                                                .addGap(18, 18, 18)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(jTextFieldAmount,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                40,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jLabelAmount))))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                                                                54,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                                GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jButtonAddNew,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                50,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jButtonSaveAmend,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                50,
                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                .addGap(63, 63, 63)));

                pack();
        }

        private void formWindowClosed(java.awt.event.WindowEvent evt) {
                MainView.main();
        }

        private void setTextFieldBorderColor() {
                Border border = BorderFactory.createLineBorder(Color.WHITE);
                jTextId.setBorder(border);
                jTextStartDate.setBorder(border);
                jTextFieldNote.setBorder(border);
                jTextFieldRecurringAmount.setBorder(border);
                jTextFieldAmount.setBorder(border);
        }

        private boolean isTextFieldDataValid() {
                TypeCheck typeCheck = new TypeCheck();
                Border border = BorderFactory.createLineBorder(Color.RED);

                if (!typeCheck.isInt(jTextId.getText())) {
                        jTextId.setBorder(border);
                        JOptionPane.showMessageDialog(new JFrame(), "Please Enter a Numeric Id");
                        return false;
                }

                if (typeCheck.isEmpty(jTextStartDate.getText())) {
                        jTextStartDate.setBorder(border);
                        JOptionPane.showMessageDialog(new JFrame(), "Please Enter a Start Date");
                        return false;
                }

                if (typeCheck.isEmpty(jTextFieldNote.getText())) {
                        jTextFieldNote.setBorder(border);
                        JOptionPane.showMessageDialog(new JFrame(), "Please Enter a Note");
                        return false;
                }

                if (!typeCheck.isInt(jTextFieldRecurringAmount.getText())) {
                        jTextFieldRecurringAmount.setBorder(border);
                        JOptionPane.showMessageDialog(new JFrame(), "Please Enter a Recurring Amount");
                        return false;
                }

                if (!typeCheck.isDouble(jTextFieldAmount.getText())) {
                        jTextFieldAmount.setBorder(border);
                        JOptionPane.showMessageDialog(new JFrame(), "Please Enter a Amount");
                        return false;
                }

                return true;
        }

        private void jButtonAddNewActionPerformed(java.awt.event.ActionEvent evt) {

                setTextFieldBorderColor();

                if (!isTextFieldDataValid())
                        return;

                int id = Integer.parseInt(jTextId.getText());
                Date startDate = new Date();
                try {
                        startDate = new SimpleDateFormat("dd/MM/yyyy").parse(jTextStartDate.getText());
                } catch (ParseException e) {
                        e.printStackTrace();
                }
                Category category = (Category) jComboBoxCategory.getSelectedItem();
                String note = jTextFieldNote.getText();
                String recurringType = jComboBoxRecurringType.getSelectedItem().toString();
                int additionalRecurringAmount = Integer.parseInt(jTextFieldRecurringAmount.getText());
                double amount = Double.parseDouble(jTextFieldAmount.getText());

                ArrayList<Transaction> transactionArray = new ArrayList<Transaction>();
                Transaction transaction = new Transaction(id, startDate, category, note, recurringType,
                                additionalRecurringAmount, amount);

                transactionArray.add(transaction);
                TransactionList transactionList = new TransactionList(transactionArray);

                TransactionRepoManager transactionRepoAdd = new TransactionRepoAdd();
                transactionRepoAdd.setTransactionList(transactionList);
                transactionRepoAdd.query();

                jTransactionTable.updateTransactionListData();

                jTextId.setText("");
                jTextStartDate.setText("");
                jComboBoxCategory.setSelectedItem(0);
                jTextFieldNote.setText("");
                jComboBoxRecurringType.setSelectedIndex(0);
                jTextFieldRecurringAmount.setText("0");
                jTextFieldAmount.setText("");

        }

        private void jButtonSaveAmendActionPerformed(java.awt.event.ActionEvent evt) {

        }

        private void jComboBoxRecurringTypeItemStateChanged(java.awt.event.ItemEvent evt) {
                String recurringType = jComboBoxRecurringType.getSelectedItem().toString();
                if (recurringType == "no") {
                        jTextFieldRecurringAmount.setEnabled(false);
                        jTextFieldRecurringAmount.setText("0");
                } else {
                        jTextFieldRecurringAmount.setEnabled(true);
                        jTextFieldRecurringAmount.setText("1");
                }

        }

}
