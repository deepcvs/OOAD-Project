import java.util.*;

public class Chef {
    private String username;
    private String password;
    private Order order;

    public Chef(Order order) {
        this.order = order;
    }

    public void MakeOrder() {
        // TODO implement here
        for (Dish dish : order.list_of_dishes) {
            System.out.println(dish.name + " Preparing...");
            System.out.println(dish.name + " Done");
        }
    }

}
