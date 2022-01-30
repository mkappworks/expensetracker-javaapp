package views.Tracker;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import controller.Tracker.TrackerDataGet;
import controller.Tracker.TrackerDataManager;
import models.Tracker.TrackerData;
import views.MainView;

public class TrackerView extends JFrame {
    // Variables declaration - do not modify
    private JScrollPane jScrollPaneTracker;
    private JTrackerTable jTrackerTable;

    // End of variables declaration

    public TrackerView() {
        initComponents();
    }

    public static void main() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrackerView().setVisible(true);
            }
        });
    }

    private void initComponents() {

        jTrackerTable = new JTrackerTable();
        jScrollPaneTracker = jTrackerTable.getScrollPane();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jScrollPaneTracker, javax.swing.GroupLayout.PREFERRED_SIZE, 479,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(52, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jScrollPaneTracker, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(52, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>

    private void formWindowClosed(java.awt.event.WindowEvent evt) {
        MainView.main();
    }

}
