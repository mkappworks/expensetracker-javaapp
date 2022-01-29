package views;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.Category.CategoryRepoGet;
import controller.Category.CategoryRepoManager;
import models.Category.Category;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class CategoryView extends JFrame {
    private JPanel contentPane;
    private JTable tableCategory;
    private JTextField textFieldID;
    private JTextField textFieldTitle;
    private JComboBox<String> comboBoxTransactionType;
    private JTextField textFieldBudget;
    private JButton btnAdd;

    public CategoryView() {
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

        CategoryRepoManager categoryRepoGet = new CategoryRepoGet();
        categoryRepoGet.query();
        ArrayList<Category> categoryArray = categoryRepoGet.getCategoryList().getList();

        String[] columnNames = { "id",
                "Title",
                "Transaction Type",
                "Budget" };

        Object[][] data = {
                { "01", "Kathy", "Smith",
                        "Snowboarding", },
                { "02", "John", "Doe",
                        "Rowing" },
                { "03", "Sue", "Black",
                        "Knitting" },
                { "04", "Jane", "White",
                        "Speed reading" },
                { "05", "Joe", "Brown",
                        "Pool" }
        };
        tableCategory = new JTable(data, columnNames);
        tableCategory.setPreferredScrollableViewportSize(new Dimension(500, 70));
        tableCategory.setFillsViewportHeight(true);
        tableCategory.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
             //   System.out.println("mouseClicked " );
            }

            @Override
            public void mousePressed(MouseEvent e) {
              //  System.out.println("mousePressed " + e.getID());

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // System.out.println("mouseReleased ");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // System.out.println("mouseEntered ");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // System.out.println("mouseExited ");
            }
        });

        GridBagConstraints gbc_tableTransaction = new GridBagConstraints();
        gbc_tableTransaction.gridwidth = 3;
        gbc_tableTransaction.gridheight = 5;
        gbc_tableTransaction.insets = new Insets(0, 0, 5, 0);
        gbc_tableTransaction.fill = GridBagConstraints.BOTH;
        gbc_tableTransaction.gridx = 2;
        gbc_tableTransaction.gridy = 2;
        contentPane.add(tableCategory, gbc_tableTransaction);

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

        JLabel lblTitle = new JLabel("Title");
        GridBagConstraints gbc_lblTitle = new GridBagConstraints();
        gbc_lblTitle.anchor = GridBagConstraints.WEST;
        gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
        gbc_lblTitle.gridx = 0;
        gbc_lblTitle.gridy = 2;
        contentPane.add(lblTitle, gbc_lblTitle);

        textFieldTitle = new JTextField();
        GridBagConstraints gbc_textFieldTitle = new GridBagConstraints();
        gbc_textFieldTitle.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldTitle.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldTitle.gridx = 1;
        gbc_textFieldTitle.gridy = 2;
        contentPane.add(textFieldTitle, gbc_textFieldTitle);
        textFieldTitle.setColumns(10);

        JLabel lblTransactionType = new JLabel("Transaction Type");
        GridBagConstraints gbc_lblTransactionType = new GridBagConstraints();
        gbc_lblTransactionType.anchor = GridBagConstraints.WEST;
        gbc_lblTransactionType.insets = new Insets(0, 0, 5, 5);
        gbc_lblTransactionType.gridx = 0;
        gbc_lblTransactionType.gridy = 3;
        contentPane.add(lblTransactionType, gbc_lblTransactionType);

        String[] transactionTypeData = { "income", "expense" };
        comboBoxTransactionType = new JComboBox<>(transactionTypeData);
        GridBagConstraints gbc_comboBoxCategory = new GridBagConstraints();
        gbc_comboBoxCategory.insets = new Insets(0, 0, 5, 5);
        gbc_comboBoxCategory.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxCategory.gridx = 1;
        gbc_comboBoxCategory.gridy = 3;
        contentPane.add(comboBoxTransactionType, gbc_comboBoxCategory);

        JLabel lblBudget = new JLabel("Budget");
        GridBagConstraints gbc_lblBudget = new GridBagConstraints();
        gbc_lblBudget.anchor = GridBagConstraints.WEST;
        gbc_lblBudget.insets = new Insets(0, 0, 5, 5);
        gbc_lblBudget.gridx = 0;
        gbc_lblBudget.gridy = 4;
        contentPane.add(lblBudget, gbc_lblBudget);

        textFieldBudget = new JTextField();
        GridBagConstraints gbc_textFieldBudget = new GridBagConstraints();
        gbc_textFieldBudget.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldBudget.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldBudget.gridx = 1;
        gbc_textFieldBudget.gridy = 4;
        contentPane.add(textFieldBudget, gbc_textFieldBudget);
        textFieldBudget.setColumns(10);

        btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = Integer.toString(comboBoxTransactionType.getSelectedIndex());
                textFieldTitle.setText(name);
            }
        });

        GridBagConstraints gbc_btnAdd = new GridBagConstraints();
        gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
        gbc_btnAdd.gridx = 0;
        gbc_btnAdd.gridy = 8;
        contentPane.add(btnAdd, gbc_btnAdd);
    }

}
