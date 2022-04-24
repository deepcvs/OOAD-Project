import java.util.*;

// public class Customer extends Admin {
public class Customer {
    private int id;
    private String username, password;
    Order order;

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void Create() {
        // If customer not in database create new customer
        System.out.println("Welcome to the Restaurant !!!!!");
        String username, password;
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Enter your username : ");
            username = input.nextLine(); // Read user input
            System.out.println("Enter your password : ");
            password = input.nextLine();
        }
        Customer customer = new Customer(username, password);

        // Add customer to the database
    }

    public void TakeOrder() {
        System.out.println("Give your order : ");
        order.AddItem();
    }

    public void AskBill() {
        // TODO implement here
        Bill bill = new Bill(order.list_of_dishes);
        Payment payment = new Payment(bill.ShowCost());
        payment.PaymentDone();
        // log the customer out
    }
}