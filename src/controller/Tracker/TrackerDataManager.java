package controller.Tracker;

import models.Tracker.TrackerDataList;

public abstract class TrackerDataManager {

    private TrackerDataList ctdList;

    public abstract void convertToCtdList();

    public TrackerDataList getCtdList() {
        return ctdList;
    }

    public void setCtdList(TrackerDataList ctdList) {
        this.ctdList = ctdList;
    }
}
