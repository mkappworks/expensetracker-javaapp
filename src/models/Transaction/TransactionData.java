package models.Transaction;

import models.Category.Category;

public class TransactionData {

    private Category category;
    private String transactionType;
    private String note;
    private double amount;

    public TransactionData(Category category, String transactionType, String note, double amount) {
        this.category = category;
        this.transactionType = transactionType;
        this.note = note;
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
