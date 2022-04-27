import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static Connection c = null;
    public static Statement stmt = null;

    public static void main(String[] args) throws SQLException {
        // Scanner input
        System.out.println("Welcome to the Restaurant!");
        Customer customer = new Customer("", "");
        boolean login_value = false;

        while (!login_value) {
            String username, password;
            try {
                System.out.println("Login : ");
                System.out.println("Enter your username : ");
                username = input.nextLine();
                System.out.println("Enter your password : ");
                password = input.nextLine();
                customer.username = username;
                customer.password = password;
            } catch (Exception e) {
                System.err.println(e);
            }
            login_value = customer.login(customer, c, stmt, input);
        }
        System.out.println("Login Successful...");

        int table_number = 0; // need to initialize effectively

        Menu menu = new Menu();
        try {
            menu.display(c, stmt);
        } catch (Exception e) {
            e.printStackTrace();
        }

        customer.TakeOrder(input);

        int delivery_id = customer.hashCode();

        Chef chef = new Chef(customer.order);
        chef.MakeOrder();

        Waiter waiter = new Waiter(delivery_id, table_number);
        waiter.Deliver();

        customer.AskBill();

        input.close();
        // stmt.close();
        // c.close();
    }
}
