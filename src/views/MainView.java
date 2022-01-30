package views;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.WindowConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView extends JFrame {

    // Variables declaration - do not modify
    private JButton jButtonCategoryView;
    private JButton jButtonTrackerView;
    private JButton jButtonTransactionView;
    // End of variables declaration

    public MainView() {
        initComponents();
    }

    public static void main() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    private void initComponents() {

        jButtonTrackerView = new JButton();
        jButtonTransactionView = new JButton();
        jButtonCategoryView = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jButtonTrackerView.setText("Tracker View");
        jButtonTrackerView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonTrackerViewActionPerformed(evt);
            }
        });

        jButtonTransactionView.setText("Transaction View");
        jButtonTransactionView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonTransactionViewActionPerformed(evt);
            }
        });

        jButtonCategoryView.setText("Category View");
        jButtonCategoryView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonCategoryViewActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButtonTransactionView, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonTrackerView, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonCategoryView, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(207, Short.MAX_VALUE)));

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jButtonTrackerView, GroupLayout.PREFERRED_SIZE, 50,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(jButtonTransactionView, GroupLayout.PREFERRED_SIZE, 50,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonCategoryView, GroupLayout.PREFERRED_SIZE, 50,
                                        GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(70, Short.MAX_VALUE)));

        pack();
    }

    private void jButtonTrackerViewActionPerformed(java.awt.event.ActionEvent evt) {
        TrackerView.main();
    }

    private void jButtonTransactionViewActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void jButtonCategoryViewActionPerformed(java.awt.event.ActionEvent evt) {
        CategoryView.main();
        this.dispose();
    }

}
