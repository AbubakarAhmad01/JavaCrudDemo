import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    static final String URL = "jdbc:mysql://localhost:3306/javacrud";
    static final String USER = "root";
    static final String PASS = "root"; // change this

    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    private static void createUser(Scanner sc) {
        try (Connection conn = connect()) {
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter email: ");
            String email = sc.nextLine();

            String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.executeUpdate();
            System.out.println("User added successfully.");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Create failed", e);
        }
    }

    private static void readUsers() {
        try (Connection conn = connect()) {
            String sql = "SELECT * FROM users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("All Users:");
            while (rs.next()) {
                System.out.printf("ID: %d | Name: %s | Email: %s%n",
                        rs.getInt("id"), rs.getString("name"), rs.getString("email"));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Read failed", e);
        }
    }

    private static void updateUser(Scanner sc) {
        try (Connection conn = connect()) {
            System.out.print("Enter user ID to update: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Enter new name: ");
            String name = sc.nextLine();
            System.out.print("Enter new email: ");
            String email = sc.nextLine();

            String sql = "UPDATE users SET name = ?, email = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setInt(3, id);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("User updated successfully.");
            } else {
                System.out.println("User ID not found.");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Update failed", e);
        }
    }

    private static void deleteUser(Scanner sc) {
        try (Connection conn = connect()) {
            System.out.print("Enter user ID to delete: ");
            int id = Integer.parseInt(sc.nextLine());

            String sql = "DELETE FROM users WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("User deleted successfully.");
            } else {
                System.out.println("User ID not found.");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Delete failed", e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== User CRUD Menu ===");
            System.out.println("1. Create User");
            System.out.println("2. View All Users");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    createUser(sc);
                    break;
                case "2":
                    readUsers();
                    break;
                case "3":
                    updateUser(sc);
                    break;
                case "4":
                    deleteUser(sc);
                    break;
                case "5":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
