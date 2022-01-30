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

    String[] columnTitles = { "Category Id", "Category Title", "Category Transaction Type", "Category Budget",
            "Amount" };
    DefaultTableModel tableModel = new DefaultTableModel(columnTitles,
            0) {
        Class[] types = new Class[] {
                String.class, String.class, String.class, String.class, String.class
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

    private JTable jTableTracker = new JTable(tableModel);
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

        jScrollPaneTracker = new JScrollPane();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        setTrackerTableData();

        jScrollPaneTracker.setViewportView(jTableTracker);

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

    private void setTrackerTableData() {
        tableModel.setRowCount(0);

        TrackerDataManager trackerDataGet = new TrackerDataGet();
        trackerDataGet.convertToCtdList();
        ArrayList<TrackerData> trackerArray = trackerDataGet.getTrackerDataList().getList();

        if (trackerArray.isEmpty())
            return;

        for (TrackerData trackerData : trackerArray) {
            Object[] rowData = new Object[] { trackerData.getCategory().getId(), trackerData.getCategory().getTitle(),
                    trackerData.getCategory().getTransactionType(),
                    trackerData.getCategory().getBudget(), trackerData.getAmount() };
            tableModel.addRow(rowData);

        }
    }
}
