import java.util.*;

// public class Customer extends Admin {
public class Customer {
    private int id;
    public String username, password;
    public Order order = new Order(null, id);

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void Create(Scanner input) {
        // If customer not in database create new customer
        System.out.println("Create a profile : ");
        String username, password;
        try {
            System.out.println("Enter your username : ");
            username = input.nextLine(); // Read user input
            System.out.println("Enter your password : ");
            password = input.nextLine();
            Customer customer = new Customer(username, password);
        } catch (Exception e) {
            System.err.println(e);
        }
            
        // Add customer to the database
    }

    public void TakeOrder(Scanner input) {
        // System.out.println("Give your order : ");
        order.AddItem(input);
        return;
    }

    public void AskBill() {
        // TODO implement here
        Bill bill = new Bill(order.list_of_dishes);
        Payment payment = new Payment(bill.ShowCost());
        payment.PaymentDone();
        // log the customer out
    }
}