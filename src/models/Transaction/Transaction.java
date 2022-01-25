package models.Transaction;

import java.util.Date;

import models.Category.Category;

public class Transaction {

    private int id;
    private Date startDate;
    private Category category;
    private String note;
    private String recurringType;
    private int additionalRecurringAmount;
    private double amount;

    public Transaction(int id, Date startDate, Category category, String note, String recurringType,
            int additionalRecurringAmount, double amount) {
        this.id = id;
        this.startDate = startDate;
        this.category = category;
        this.note = note;
        this.recurringType = recurringType;
        this.additionalRecurringAmount = additionalRecurringAmount;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getRecurringType() {
        return recurringType;
    }

    public void setRecurringType(String recurringType) {
        this.recurringType = recurringType;
    }

    public int getAdditionalRecurringAmount() {
        return additionalRecurringAmount;
    }

    public void setAdditionalRecurringAmount(int additionalRecurringAmount) {
        this.additionalRecurringAmount = additionalRecurringAmount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
