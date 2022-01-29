package models.Tracker;

import java.util.ArrayList;

public class CategoryTrackerDataList {

    private ArrayList<CategoryTrackerData> list;

    public CategoryTrackerDataList(ArrayList<CategoryTrackerData> list) {
        this.list = list;
    }

    public ArrayList<CategoryTrackerData> getList() {
        return list;
    }

    public void setList(ArrayList<CategoryTrackerData> list) {
        this.list = list;
    }

}
