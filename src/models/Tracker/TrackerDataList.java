package models.Tracker;

import java.util.ArrayList;

public class TrackerDataList {

    private ArrayList<TrackerData> list;

    public TrackerDataList(ArrayList<TrackerData> list) {
        this.list = list;
    }

    public ArrayList<TrackerData> getList() {
        return list;
    }

    public void setList(ArrayList<TrackerData> list) {
        this.list = list;
    }

}
