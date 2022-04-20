import java.io.*;
import java.util.Scanner;

public class Menu {
    public static void display() throws Exception {
        Scanner sc = new Scanner(new File("D:\\study\\computer science\\OOAD\\OOAD-Project\\Menu.csv"));
        sc.useDelimiter(","); // sets the delimiter pattern
        while (sc.hasNext()) // returns a boolean value
        {
            System.out.print(sc.next() + " "); // find and returns the next complete token from this scanner
        }
        sc.close(); // closes the scanner
    }

    public static void addItem(Dish dish) throws Exception {
        FileWriter pw = new FileWriter("D:\\study\\computer science\\OOAD\\OOAD-Project\\Menu.csv");
        pw.append(dish.name);
        pw.append(",");
        pw.append(dish.price);
        pw.append("\n");
        pw.flush();
        pw.close();
    }

    public static void main(String[] args) throws Exception {
        Dish dish;
        
        display();
    }
}