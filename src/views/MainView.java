package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import javax.swing.SwingConstants;

public class MainView extends JFrame {

    private JPanel contentPane;

    public MainView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
        gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
        gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        contentPane.setLayout(gbl_contentPane);

        JButton btncategoryBudgetTracker = new JButton("Category Budget Tracker");
        btncategoryBudgetTracker.setHorizontalAlignment(SwingConstants.LEFT);
        btncategoryBudgetTracker.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        GridBagConstraints gbc_btncategoryBudgetTracker = new GridBagConstraints();
        gbc_btncategoryBudgetTracker.gridheight = 2;
        gbc_btncategoryBudgetTracker.insets = new Insets(0, 0, 5, 0);
        gbc_btncategoryBudgetTracker.gridx = 1;
        gbc_btncategoryBudgetTracker.gridy = 2;
        contentPane.add(btncategoryBudgetTracker, gbc_btncategoryBudgetTracker);

        JButton btnTransactionView = new JButton("Transactions View");
        btnTransactionView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TransactionView().setVisible(true);
            }
        });

        btnTransactionView.setHorizontalAlignment(SwingConstants.LEFT);
        GridBagConstraints gbc_btnTransactionView = new GridBagConstraints();
        gbc_btnTransactionView.anchor = GridBagConstraints.NORTHWEST;
        gbc_btnTransactionView.insets = new Insets(0, 0, 5, 0);
        gbc_btnTransactionView.gridx = 1;
        gbc_btnTransactionView.gridy = 5;
        contentPane.add(btnTransactionView, gbc_btnTransactionView);

        JButton btnCategoryView = new JButton("CategoryView");
        btnCategoryView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new CategoryView().setVisible(true);
            }
        });
        btnCategoryView.setHorizontalAlignment(SwingConstants.LEFT);
        GridBagConstraints gbc_btnCategoryView = new GridBagConstraints();
        gbc_btnCategoryView.anchor = GridBagConstraints.WEST;
        gbc_btnCategoryView.gridx = 1;
        gbc_btnCategoryView.gridy = 7;
        contentPane.add(btnCategoryView, gbc_btnCategoryView);
    }

}
