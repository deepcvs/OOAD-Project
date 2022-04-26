import java.util.*;

// public class Customer extends Admin {
public class Customer {
    private int id = 1;
    public String username, password;
    private List<Dish> list_of_dishes = new ArrayList<Dish>();
    public Order order = new Order(list_of_dishes, id);

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void Create(Scanner input) {
        // If customer not in database create new customer
        System.out.println("Create a profile : ");
        String username, password;
        try {
            System.out.println("Enter your username");
            username = input.nextLine(); // Read user input
            System.out.println("Enter your password");
            password = input.nextLine();
            Customer customer = new Customer(username, password);
        } catch (Exception e) {
            System.err.println(e);
        }

        // Add customer to the database
    }

    public void TakeOrder(Scanner input) {
        int taking = 1;
        while (taking != 0) {
            if(taking == 1)
            {
                order.AddItem(input);
            }
            else if(taking == 2)
            {
                order.RemoveItem(input);
            }
            else {
                System.out.println("Enter Valid Number");
            }
            try {
                if(list_of_dishes.isEmpty())
                {
                    for (Dish dish : list_of_dishes) {
                        System.out.println(dish.name + "+" + dish.price);
                    }
                }
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