public class WeeklyPlan extends MealPlan {
    public WeeklyPlan(int planId, String name, double price) {
        super(planId, name, price);
    }

    @Override
    public void displayPlan() {
        System.out.println("Weekly Plan: " + name + " - $" + price);
    }
}