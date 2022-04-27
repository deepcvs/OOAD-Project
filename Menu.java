import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Menu {
    public void display(Connection c, Statement stmt) throws Exception {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/restaurant",
                            "postgres", "postgres");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select * from menu;");
            while (rs.next()) {
                String name = rs.getString("dish");
                int price = rs.getInt("price");
                System.out.println("NAME = " + name);
                System.out.println("PRICE = " + price);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addItem(Dish dish, Connection c, Statement stmt) throws Exception {
        // FileWriter pw = new FileWriter("Menu.csv", true);
        // pw.append("\n");
        // pw.append(dish.name);
        // pw.append(",");
        // pw.append(dish.price);
        // pw.append("\n");
        // pw.flush();
        // pw.close();
        Class.forName("org.postgresql.Driver");
        c = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/restaurant",
                        "postgres", "postgres");
        c.setAutoCommit(false);
        // System.out.println("Opened database successfully");

        stmt = c.createStatement();
        String sql = "insert into menu values (dish, price) '" + dish.name + "'," + Integer.parseInt(dish.price) + ");";
        stmt.executeUpdate(sql);
        c.commit();
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
