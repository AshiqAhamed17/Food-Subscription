public class Subscription {
    private int subscriptionId;
    private Customer customer;
    private MealPlan mealPlan;

    public Subscription(int subscriptionId, Customer customer, MealPlan mealPlan) {
        this.subscriptionId = subscriptionId;
        this.customer = customer;
        this.mealPlan = mealPlan;
    }

    // Getters and Setters
    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public MealPlan getMealPlan() {
        return mealPlan;
    }

    public void setMealPlan(MealPlan mealPlan) {
        this.mealPlan = mealPlan;
    }

    // Display Subscription details
    public void displaySubscription() {
        System.out.println("Subscription ID: " + subscriptionId);
        System.out.println("Customer: " + customer.getName() + " (" + customer.getEmail() + ")");
        mealPlan.displayPlan();
    }
}