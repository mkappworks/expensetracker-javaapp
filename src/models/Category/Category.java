package models.Category;

public class Category {

    private int id;
    private String title;
    private double budget;
    private String transactionType;

    public Category(int id, String title, double budget, String transactionType) {
        this.id = id;
        this.title = title;
        this.budget = budget;
        this.transactionType = transactionType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String toString() {
        return this.title;
    }
}
