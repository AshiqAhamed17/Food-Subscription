public interface Subscribable {
    void createSubscription(Customer customer, MealPlan mealPlan);
    void updateSubscription(int subscriptionId, MealPlan newMealPlan);
    void processPayment(int subscriptionId, double amount);
}