package controller.Recurring;

public class RecurringFactory extends AbstractFactory {

    @Override
    public TransactionRecurringManager getManager(String recurringType) {

        if (recurringType.equals("daily")) {
            return new DailyRecurring();
        } else if (recurringType.equals("monthly")) {
            return new MonthlyRecurring();
        } else if (recurringType.equals("no")) {
            return new NoRecurring();
        }
        return null;
    }

}
