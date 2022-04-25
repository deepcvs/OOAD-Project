import java.util.Scanner;

public class Main {
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
        System.out.println("Welcome to the Restaurant !!!");
        Customer customer = new Customer("", "");
        boolean login_value = false;

        while (!login_value) {
            String username, password;
            try (Scanner input = new Scanner(System.in)) {
                System.out.println("Enter your username : ");
                username = input.nextLine(); // Read user input
                System.out.println("Enter your password : ");
                password = input.nextLine();
                input.close();
            }
            customer.username = username;
            customer.password = password;
            login_value = login(customer);
        }

        int table_number = 0; // need to initialize effectively

        Menu menu = new Menu();
        try {
            menu.display();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        int taking = 1;
        while (taking == 1) {
            customer.TakeOrder();
            System.out.println("Enter 1 to continue to give order else enter 0 to finalize order");
            try (Scanner input = new Scanner(System.in)) {
                taking = Integer.parseInt(input.nextLine());
                input.close();
            }
        }

        int delivery_id = 0; // need to initialize effectively

        Chef chef = new Chef(customer.order);
        chef.MakeOrder();

        Waiter waiter = new Waiter(delivery_id, table_number);
        waiter.Deliver();
    }
}
