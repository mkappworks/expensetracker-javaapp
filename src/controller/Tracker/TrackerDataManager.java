package controller.Tracker;

import models.Tracker.CategoryTrackerDataList;

public abstract class TrackerDataManager {

    private CategoryTrackerDataList ctdList;

    public abstract void convertToCtdList();

    public CategoryTrackerDataList getCtdList() {
        return ctdList;
    }

    public void setCtdList(CategoryTrackerDataList ctdList) {
        this.ctdList = ctdList;
    }
}
