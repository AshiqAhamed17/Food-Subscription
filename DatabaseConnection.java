import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/food_delivery"; // Update with your database name if different
    private static final String USER = "root"; // Replace with your MySQL username
    private static final String PASSWORD = "backend69"; // Replace with your MySQL password

    public static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database successfully!");
        } catch (SQLException e) {
            System.out.println("Error connecting to the database.");
            e.printStackTrace();
        }
        return connection;
    }

    public static void disconnect(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Disconnected from the database.");
            }
        } catch (SQLException e) {
            System.out.println("Error closing the connection.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Test the connection
        Connection conn = connect();
        disconnect(conn);
    }
}