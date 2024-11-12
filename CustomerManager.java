import java.sql.*;

public class CustomerManager {

    // Method to insert a customer into the Customer table
    public void insertCustomer(String name, String email, String address) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/food_delivery";
        String user = "root";  // or your database username
        String password = "backend69";  // or your database password
        
        // SQL query to insert a new customer
        String query = "INSERT INTO Customer (name, email, address) VALUES (?, ?, ?)";
        
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            // Set the values for the query parameters
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, address);
            
            // Execute the insert query
            int rowsAffected = preparedStatement.executeUpdate();
            
            // Check if the insertion was successful
            if (rowsAffected > 0) {
                System.out.println("Customer inserted successfully!");
            } else {
                System.out.println("Failed to insert customer.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CustomerManager manager = new CustomerManager();
        
        // Insert new customers
        manager.insertCustomer("Alice Smith", "alice@example.com", "456 Park Ave");
        manager.insertCustomer("Bob Johnson", "bob@example.com", "789 Elm St");
        manager.insertCustomer("Charlie Brown", "charlie@example.com", "321 Oak Blvd");
    }
}