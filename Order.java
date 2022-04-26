import java.util.*;

public class Order {
    private int id;
    public List<Dish> list_of_dishes;
    public int status; // 1 if order is delivered 0 if still under preparation

    public Order(List<Dish> list_of_dishes, int status) {
        this.list_of_dishes = list_of_dishes;
        this.status = status;
    }

    public void AddItem(Scanner input) {
        // TODO implement here
        String name, price;
        try(input) {
            System.out.println("Enter Dish name: ");
            name = input.nextLine(); // Read user input
            System.out.println("Enter the price: ");
            price = input.nextLine();
            Dish dish = new Dish(name, price);
            list_of_dishes.add(dish);
        }  catch (Exception e) {
            System.err.println(e);
        }
    }

    public void RemoveItem(Scanner input) {
        String name, price;
        try {
            System.out.println("Enter Dish name : ");
            name = input.nextLine(); // Read user input
            System.out.println("Enter the price : ");
            price = input.nextLine();
            Dish dish = new Dish(name, price);
            list_of_dishes.remove(dish);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}