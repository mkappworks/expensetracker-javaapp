package controller.Recurring;

public abstract class AbstractFactory {
    public abstract TransactionRecurringManager getManager(String recurringType);
}
