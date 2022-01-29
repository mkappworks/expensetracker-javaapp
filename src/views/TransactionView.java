package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Category.CategoryRepoGet;
import controller.Category.CategoryRepoManager;
import models.Category.Category;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class TransactionView extends JFrame {
    private JPanel contentPane;
    private JTable tableTransaction;
    private JTextField textFieldID;
    private JTextField textFieldStartDate;
    private JComboBox<String> comboBoxCategory;
    private JTextField textFieldNote;
    private JComboBox<String> comboBoxRecurringType;
    private JTextField textFieldAdditionalRecurringAmount;
    private JTextField textFieldAmount;
    private JButton btnAdd;

    public TransactionView() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                setVisible(false);
                new MainView().setVisible(true);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[] { 0, 252, 0, 0, 284, 0 };
        gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
        gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                Double.MIN_VALUE };
        contentPane.setLayout(gbl_contentPane);

        tableTransaction = new JTable();
        GridBagConstraints gbc_tableTransaction = new GridBagConstraints();
        gbc_tableTransaction.gridwidth = 3;
        gbc_tableTransaction.gridheight = 5;
        gbc_tableTransaction.insets = new Insets(0, 0, 5, 0);
        gbc_tableTransaction.fill = GridBagConstraints.BOTH;
        gbc_tableTransaction.gridx = 2;
        gbc_tableTransaction.gridy = 2;
        contentPane.add(tableTransaction, gbc_tableTransaction);

        JLabel lblId = new JLabel("id");
        GridBagConstraints gbc_lblId = new GridBagConstraints();
        gbc_lblId.anchor = GridBagConstraints.WEST;
        gbc_lblId.insets = new Insets(0, 0, 5, 5);
        gbc_lblId.gridx = 0;
        gbc_lblId.gridy = 1;
        contentPane.add(lblId, gbc_lblId);

        textFieldID = new JTextField();
        GridBagConstraints gbc_textFieldID = new GridBagConstraints();
        gbc_textFieldID.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldID.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldID.gridx = 1;
        gbc_textFieldID.gridy = 1;
        contentPane.add(textFieldID, gbc_textFieldID);
        textFieldID.setColumns(10);

        JLabel lblStartDate = new JLabel("Start Date");
        GridBagConstraints gbc_lblStartDate = new GridBagConstraints();
        gbc_lblStartDate.anchor = GridBagConstraints.WEST;
        gbc_lblStartDate.insets = new Insets(0, 0, 5, 5);
        gbc_lblStartDate.gridx = 0;
        gbc_lblStartDate.gridy = 2;
        contentPane.add(lblStartDate, gbc_lblStartDate);

        textFieldStartDate = new JTextField();
        GridBagConstraints gbc_textFieldStart = new GridBagConstraints();
        gbc_textFieldStart.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldStart.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldStart.gridx = 1;
        gbc_textFieldStart.gridy = 2;
        contentPane.add(textFieldStartDate, gbc_textFieldStart);
        textFieldStartDate.setColumns(10);

        JLabel lblCategory = new JLabel("Category");
        GridBagConstraints gbc_lblCategory = new GridBagConstraints();
        gbc_lblCategory.anchor = GridBagConstraints.WEST;
        gbc_lblCategory.insets = new Insets(0, 0, 5, 5);
        gbc_lblCategory.gridx = 0;
        gbc_lblCategory.gridy = 3;
        contentPane.add(lblCategory, gbc_lblCategory);

        CategoryRepoManager categoryRepoGet = new CategoryRepoGet();
        categoryRepoGet.query();
        ArrayList<Category> categoryArray = categoryRepoGet.getCategoryList().getList();

        comboBoxCategory = new JComboBox<>();
        for (Category category : categoryArray) {
            comboBoxCategory.addItem(category.getTitle());
        }
        GridBagConstraints gbc_comboBoxCategory = new GridBagConstraints();
        gbc_comboBoxCategory.insets = new Insets(0, 0, 5, 5);
        gbc_comboBoxCategory.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxCategory.gridx = 1;
        gbc_comboBoxCategory.gridy = 3;
        contentPane.add(comboBoxCategory, gbc_comboBoxCategory);

        JLabel lblNote = new JLabel("Note");
        GridBagConstraints gbc_lblNote = new GridBagConstraints();
        gbc_lblNote.anchor = GridBagConstraints.WEST;
        gbc_lblNote.insets = new Insets(0, 0, 5, 5);
        gbc_lblNote.gridx = 0;
        gbc_lblNote.gridy = 4;
        contentPane.add(lblNote, gbc_lblNote);

        textFieldNote = new JTextField();
        GridBagConstraints gbc_textFieldNote = new GridBagConstraints();
        gbc_textFieldNote.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldNote.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldNote.gridx = 1;
        gbc_textFieldNote.gridy = 4;
        contentPane.add(textFieldNote, gbc_textFieldNote);
        textFieldNote.setColumns(10);

        JLabel lblRecurringType = new JLabel("Recurring Type");
        GridBagConstraints gbc_lblRecurringType = new GridBagConstraints();
        gbc_lblRecurringType.anchor = GridBagConstraints.WEST;
        gbc_lblRecurringType.insets = new Insets(0, 0, 5, 5);
        gbc_lblRecurringType.gridx = 0;
        gbc_lblRecurringType.gridy = 5;
        contentPane.add(lblRecurringType, gbc_lblRecurringType);

        String[] recurringTypeData = { "norecurring", "dailyrecurring", "monthlyRecurring" };
        comboBoxRecurringType = new JComboBox<String>(recurringTypeData);
        comboBoxRecurringType.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String recurringType = comboBoxRecurringType.getSelectedItem().toString();
                System.out.println(recurringType);
                if (recurringType == "norecurring") {
                    textFieldAdditionalRecurringAmount.setText("0");
                    textFieldAdditionalRecurringAmount.setEnabled(false);
                } else {
                    textFieldAdditionalRecurringAmount.setEnabled(true);
                }
            }
        });
        GridBagConstraints gbc_comboBoxRecurringType = new GridBagConstraints();
        gbc_comboBoxRecurringType.insets = new Insets(0, 0, 5, 5);
        gbc_comboBoxRecurringType.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxRecurringType.gridx = 1;
        gbc_comboBoxRecurringType.gridy = 5;
        contentPane.add(comboBoxRecurringType, gbc_comboBoxRecurringType);

        JLabel lblRecurringAmount = new JLabel("Recurring Amount");
        GridBagConstraints gbc_lblRecurringAmount = new GridBagConstraints();
        gbc_lblRecurringAmount.anchor = GridBagConstraints.EAST;
        gbc_lblRecurringAmount.insets = new Insets(0, 0, 5, 5);
        gbc_lblRecurringAmount.gridx = 0;
        gbc_lblRecurringAmount.gridy = 6;
        contentPane.add(lblRecurringAmount, gbc_lblRecurringAmount);

        textFieldAdditionalRecurringAmount = new JTextField();
        textFieldAdditionalRecurringAmount.setText("0");
        textFieldAdditionalRecurringAmount.setEnabled(false);
        GridBagConstraints gbc_textFieldAdditionalRecurringAmount = new GridBagConstraints();
        gbc_textFieldAdditionalRecurringAmount.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldAdditionalRecurringAmount.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldAdditionalRecurringAmount.gridx = 1;
        gbc_textFieldAdditionalRecurringAmount.gridy = 6;
        contentPane.add(textFieldAdditionalRecurringAmount, gbc_textFieldAdditionalRecurringAmount);
        textFieldAdditionalRecurringAmount.setColumns(10);

        JLabel lblAmount = new JLabel("Amount");
        GridBagConstraints gbc_lblAmount = new GridBagConstraints();
        gbc_lblAmount.anchor = GridBagConstraints.WEST;
        gbc_lblAmount.insets = new Insets(0, 0, 5, 5);
        gbc_lblAmount.gridx = 0;
        gbc_lblAmount.gridy = 7;
        contentPane.add(lblAmount, gbc_lblAmount);

        textFieldAmount = new JTextField();
        GridBagConstraints gbc_textFieldAmount = new GridBagConstraints();
        gbc_textFieldAmount.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldAmount.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldAmount.gridx = 1;
        gbc_textFieldAmount.gridy = 7;
        contentPane.add(textFieldAmount, gbc_textFieldAmount);
        textFieldAmount.setColumns(10);

        btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = Integer.toString(comboBoxRecurringType.getSelectedIndex());
                textFieldAmount.setText(name);
            }
        });

        GridBagConstraints gbc_btnAdd = new GridBagConstraints();
        gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
        gbc_btnAdd.gridx = 0;
        gbc_btnAdd.gridy = 8;
        contentPane.add(btnAdd, gbc_btnAdd);
    }

}
