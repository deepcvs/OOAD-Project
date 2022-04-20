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

    public static void main(String[] args) throws Exception {
        display();
    }
}