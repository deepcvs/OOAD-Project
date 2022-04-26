import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    private static boolean login(Customer customer) {
        // if (username in database) {
        // proceed;
        // return true;
        // }
        // else {
        // Customer customer = new Customer(username, password);
        // customer.Create();
        // return false;
        // }
        return true;
    }

    public static void main(String[] args) {
        // Scanner input 
        System.out.println("Welcome to the Restaurant!");
        Customer customer = new Customer("", "");
        boolean login_value = false;

        while (!login_value) {
            String username, password;
            try {
                System.out.println("Enter your username : ");
                username = input.nextLine(); // Read user input
                System.out.println("Enter your password : ");
                password = input.nextLine();
                // input.close();
                customer.username = username;
                customer.password = password;
            } catch (Exception e) {
                System.err.println(e);
            }
            login_value = login(customer);
        }

        int table_number = 0; // need to initialize effectively

        Menu menu = new Menu();
        try {
            menu.display();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        customer.TakeOrder(input);

        int delivery_id = customer.hashCode();

        Chef chef = new Chef(customer.order);
        chef.MakeOrder();

        Waiter waiter = new Waiter(delivery_id, table_number);
        waiter.Deliver();

        input.close();
    }
}
