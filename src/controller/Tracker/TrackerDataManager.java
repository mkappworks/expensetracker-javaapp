package controller.Tracker;

import models.Tracker.TrackerDataList;

public abstract class TrackerDataManager {

    private TrackerDataList trackerDataList;

    public abstract void convertToCtdList();

    public TrackerDataList getTrackerDataList() {
        return trackerDataList;
    }

    public void setTrackerDataList(TrackerDataList trackerDataList) {
        this.trackerDataList = trackerDataList;
    }


}
