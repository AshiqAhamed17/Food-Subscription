public class Main {
    public static void main(String[] args) {
        // Test the subscription system by creating a customer and meal plan
        
        // Create a customer (you can modify the details here)
        Customer customer = new Customer(1, "John Doe", "john@example.com", "123 Street, City");
        
        // Create a meal plan (you can change plan type and price)
        MealPlan weeklyPlan = new WeeklyPlan(1, "Weekly Plan", 29.99);  // Use WeeklyPlan or MonthlyPlan
        
        // Create the SubscriptionManager to manage subscriptions
        SubscriptionManager manager = new SubscriptionManager();
        
        // Create a subscription for the customer
        manager.createSubscription(customer, weeklyPlan);
        
        // Update the subscription to a different meal plan (e.g., MonthlyPlan)
        MealPlan monthlyPlan = new MonthlyPlan(2, "Monthly Plan", 89.99);
        manager.updateSubscription(1, monthlyPlan);  // Assuming subscriptionId = 1 for this example
        
        // Process a payment for the subscription (subscriptionId = 1)
        manager.processPayment(1, 89.99);  // Process payment for subscription ID 1
        
        // Optionally, you can print all subscriptions, payments, etc. to test.
    }
}