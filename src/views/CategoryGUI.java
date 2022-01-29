package views;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.Category.CategoryRepoGet;
import controller.Category.CategoryRepoManager;
import models.Category.Category;

public class CategoryGUI extends JFrame {

    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    JTextField tfId, tfFirstName, tfLastName;
    JTable tableCategory;

    public void initialise() {
        /**************** Form Panel ****************/
        JLabel lbId = new JLabel("Category Id");
        lbId.setFont(mainFont);

        tfId = new JTextField();
        tfId.setFont(mainFont);

        JLabel lbFirstName = new JLabel("First Name");
        lbFirstName.setFont(mainFont);

        tfFirstName = new JTextField();
        tfFirstName.setFont(mainFont);

        JLabel lbLastName = new JLabel("Last Name");
        lbLastName.setFont(mainFont);

        tfLastName = new JTextField();
        tfLastName.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 2, 5, 5));
        formPanel.setOpaque(false);
        formPanel.add(lbId);
        formPanel.add(tfId);
        formPanel.add(lbFirstName);
        formPanel.add(tfFirstName);
        formPanel.add(lbLastName);
        formPanel.add(tfLastName);

        /**************** Table Panel ****************/
        CategoryRepoManager categoryRepoGet = new CategoryRepoGet();
        categoryRepoGet.query();
        ArrayList<Category> categoryArray = categoryRepoGet.getCategoryList().getList();

        String[] columnNames = { "id", "title", "budget" };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        ArrayList<String> list = new ArrayList<String>();

        for (Category categoryRecord : categoryArray) {
            list.add(Integer.toString(categoryRecord.getId()));
            list.add(categoryRecord.getTitle());
            list.add(Double.toString(categoryRecord.getBudget()));
            model.addRow(list.toArray());
        }

        JTable tableCategory = new JTable(model);
        tableCategory.setModel(model);
        tableCategory.setBounds(30, 40, 200, 300);
        JScrollPane tablePanel = new JScrollPane(tableCategory);

        /**************** Buttons Panel ****************/
        JButton btnSave = new JButton("Save");
        btnSave.setFont(mainFont);
        btnSave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 3, 5, 5));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(btnSave);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(211, 211, 211));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(tablePanel, BorderLayout.EAST);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setTitle("Category Form");
        setSize(500, 600);
        setMinimumSize(new Dimension(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
