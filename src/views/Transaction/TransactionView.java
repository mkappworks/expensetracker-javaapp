package views.Transaction;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.JComboBox;

import views.MainView;

public class TransactionView extends JFrame {

        // Variables declaration - do not modify
        private JButton jButtonAddNew;
        private JButton jButtonSaveAmend;
        private JComboBox<String> jComboBoxCategory;
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

                jLabelCategory = new JLabel();
                jTextStartDate = new JTextField();
                jLabelNote = new JLabel();
                jLabelId = new JLabel();
                jTextFieldNote = new JTextField();
                jTextId = new JTextField();
                jComboBoxCategory = new JComboBox<>();
                jLabelStartDate = new JLabel();
                jButtonAddNew = new JButton();
                jLabelRecurringType = new JLabel();
                jComboBoxRecurringType = new JComboBox<>();
                jLabelRecurringAmount = new JLabel();
                jTextFieldRecurringAmount = new JTextField();
                jLabelAmount = new JLabel();
                jTextFieldAmount = new JTextField();
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

                jComboBoxCategory.addItemListener(new java.awt.event.ItemListener() {
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                jComboBoxCategoryItemStateChanged(evt);
                        }
                });

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
                                                new String[] { "norecurring", "monthly", "daily" }));
                jComboBoxRecurringType.addItemListener(new java.awt.event.ItemListener() {
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                jComboBoxRecurringTypeItemStateChanged(evt);
                        }
                });

                jLabelRecurringAmount.setText("Recurring Amount");

                jTextFieldRecurringAmount.setText("0");
                jTextFieldRecurringAmount.setToolTipText("");
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

        private void jButtonAddNewActionPerformed(java.awt.event.ActionEvent evt) {
                jTransactionTable.updateCategoryListData();
        }

        private void jButtonSaveAmendActionPerformed(java.awt.event.ActionEvent evt) {

        }

        private void jComboBoxCategoryItemStateChanged(java.awt.event.ItemEvent evt) {

        }

        private void jComboBoxRecurringTypeItemStateChanged(java.awt.event.ItemEvent evt) {

        }

}
