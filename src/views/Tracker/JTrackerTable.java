package views.Tracker;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import controller.Tracker.TrackerDataGet;
import controller.Tracker.TrackerDataManager;
import models.Tracker.TrackerData;

public class JTrackerTable extends JTable {

    private JTable table = new JTable();
    private JScrollPane scrollpane = new JScrollPane();
    private TrackerTableModel tableModel;

    public JTrackerTable() {
        initComponents();

    }

    private void initComponents() {
        tableModel = new TrackerTableModel(getTrackerListData());
        table.setModel(tableModel);
        table.setBounds(new java.awt.Rectangle(0, 20, 450, 64));
        table.setColumnSelectionAllowed(true);
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.getColumnModel().getSelectionModel()
                .setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        scrollpane = new JScrollPane(table);
        scrollpane.setPreferredSize(new Dimension(400, 200));
        add(scrollpane, BorderLayout.CENTER);
        setVisible(true);
    }

    public JScrollPane getScrollPane() {
        return this.scrollpane;
    }

    private List<TrackerData> getTrackerListData() {
        TrackerDataManager trackerDataGet = new TrackerDataGet();
        trackerDataGet.convertToCtdList();
        List<TrackerData> listTracker = trackerDataGet.getTrackerDataList().getList();

        return listTracker;
    }

    private void setTrackerTableData() {
        // tableModel.setRowCount(0);

        // if (trackerArray.isEmpty())
        // return;

        // for (TrackerData trackerData : trackerArray) {
        // Object[] rowData = new Object[] { trackerData.getCategory().getId(),
        // trackerData.getCategory().getTitle(),
        // trackerData.getCategory().getTransactionType(),
        // trackerData.getCategory().getBudget(), trackerData.getAmount() };
        // tableModel.addRow(rowData);

        // }
    }

}
