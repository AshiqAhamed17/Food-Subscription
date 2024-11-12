public class MonthlyPlan extends MealPlan {
    public MonthlyPlan(int planId, String name, double price) {
        super(planId, name, price);
    }

    @Override
    public void displayPlan() {
        System.out.println("Monthly Plan: " + name + " - $" + price);
    }
}