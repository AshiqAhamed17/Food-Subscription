import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionManager implements Subscribable {
    private List<Subscription> subscriptions = new ArrayList<>();

    @Override
    public void createSubscription(Customer customer, MealPlan mealPlan) {
        Connection conn = DatabaseConnection.connect();
        String sql = "INSERT INTO Subscription (customer_id, meal_plan_id) VALUES (?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // Set the parameters for the query
            stmt.setInt(1, customer.getId());
            stmt.setInt(2, mealPlan.getPlanId());
            
            // Execute the statement
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int subscriptionId = generatedKeys.getInt(1);
                        Subscription subscription = new Subscription(subscriptionId, customer, mealPlan);
                        subscriptions.add(subscription);
                        System.out.println("Subscription created successfully with ID: " + subscriptionId);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error creating subscription.");
            e.printStackTrace();
        } finally {
            DatabaseConnection.disconnect(conn);
        }
    }

    @Override
    public void updateSubscription(int subscriptionId, MealPlan newMealPlan) {
        Connection conn = DatabaseConnection.connect();
        String sql = "UPDATE Subscription SET meal_plan_id = ? WHERE subscription_id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, newMealPlan.getPlanId());
            stmt.setInt(2, subscriptionId);
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Subscription updated successfully!");
            } else {
                System.out.println("Subscription not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating subscription.");
            e.printStackTrace();
        } finally {
            DatabaseConnection.disconnect(conn);
        }
    }

    @Override
    public void processPayment(int subscriptionId, double amount) {
        Connection conn = DatabaseConnection.connect();
        String sql = "INSERT INTO Payment (subscription_id, amount, payment_date, status) VALUES (?, ?, NOW(), ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, subscriptionId);
            stmt.setDouble(2, amount);
            stmt.setString(3, "Successful");  // Example status, you can adjust based on real logic
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Payment processed successfully for subscription ID: " + subscriptionId);
            } else {
                System.out.println("Error processing payment.");
            }
        } catch (SQLException e) {
            System.out.println("Error processing payment.");
            e.printStackTrace();
        } finally {
            DatabaseConnection.disconnect(conn);
        }
    }

    // For demonstration, you can implement additional helper methods to fetch data, list subscriptions, etc.
}