public abstract class MealPlan {
    protected int planId;
    protected String name;
    protected double price;

    public MealPlan(int planId, String name, double price) {
        this.planId = planId;
        this.name = name;
        this.price = price;
    }

    // Abstract method to display meal plan details
    public abstract void displayPlan();

    // Getters and Setters
    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}