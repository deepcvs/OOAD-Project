import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// public class Customer extends Admin {
public class Customer {
    // private int id = 1;
    public String username, password;
    private List<Dish> list_of_dishes = new ArrayList<Dish>();
    public Order order = new Order(list_of_dishes, 0);

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login(Customer customer, Connection c, Statement stmt, Scanner input) {
        // if (username in database) {
        // proceed;
        // return true;
        // }
        // else {
        // Customer customer = new Customer(username, password);
        // customer.Create();
        // return false;
        // }
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/restaurant",
                            "postgres", "postgres");
            c.setAutoCommit(false);
            // System.out.println("Opened database successfully");
            String statement = "select * from customer where username='" + customer.username + "' and password='"
                    + customer.password + "';";
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(statement);
            if (rs.next()) {
                rs.close();
                return true;
            } else {
                rs.close();
                Create(c, stmt, input);
                return false;
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return false;
    }

    public void Create(Connection c, Statement stmt, Scanner input) {
        // If customer not in database create new customer
        System.out.println("Create a profile : ");
        String username, password;
        try {
            System.out.println("Enter your username");
            username = input.nextLine(); // Read user input
            System.out.println("Enter your password");
            password = input.nextLine();
            // Customer customer = new Customer(username, password);
            // Add customer to the database
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/restaurant",
                            "postgres", "postgres");
            c.setAutoCommit(false);
            // System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO CUSTOMER (USERNAME,PASSWORD) "
                    + "VALUES (" + username + "," + password + ");";
            stmt.executeUpdate(sql);
            c.commit();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void TakeOrder(Scanner input) {
        int taking = 1;
        while (taking != 0) {
            try {
                switch (taking) {
                    case 1: {
                        order.AddItem(input);
                        break;
                    }
                    case 2: {
                        order.RemoveItem(input); // doesn't work
                        break;
                    }
                    default:
                        System.out.println("Enter Valid Number");
                }
                System.out.println("\nYour current order is:");
                for (Dish dish : list_of_dishes) {
                    System.out.println(dish.name + " " + dish.price);
                }
                System.out.println("\n");
                System.out.println("Enter\n0 to Finalize\n1 to Add Dish\n2 to Remove Dish");
                taking = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

    public void AskBill() {
        // TODO implement here
        Bill bill = new Bill(order.list_of_dishes);
        Payment payment = new Payment(bill.ShowCost());
        payment.PaymentDone();
        // log the customer out
    }
}
