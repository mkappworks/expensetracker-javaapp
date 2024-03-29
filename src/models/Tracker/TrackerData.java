package models.Tracker;

import models.Category.Category;

public class TrackerData {

    private Category category;
    private double amount;

    public TrackerData(Category category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
