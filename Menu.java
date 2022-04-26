import java.io.*;
import java.util.Scanner;

public class Menu {
    public void display() throws Exception {
        Scanner sc = new Scanner(new File("Menu.csv"));
        sc.useDelimiter(","); // sets the delimiter pattern
        while (sc.hasNext()) // returns a boolean value
        {
            System.out.print(sc.next() + " "); // find and returns the next complete token from this scanner
        }
        sc.close(); // closes the scanner
    }

    public void addItem(Dish dish) throws Exception {
        FileWriter pw = new FileWriter("Menu.csv", true);
        pw.append("\n");
        pw.append(dish.name);
        pw.append(",");
        pw.append(dish.price);
        pw.append("\n");
        pw.flush();
        pw.close();
    }

    // public static void main(String[] args) throws Exception {
    // String name, price;
    // try (Scanner input = new Scanner(System.in)) {
    // System.out.println("Enter Dish name : ");

    // name = input.nextLine(); // Read user input
    // price = input.nextLine();
    // }
    // Dish dish = new Dish(name, price);
    // addItem(dish);
    // System.out.println("Updated Menu");
    // display();
    // }
}
