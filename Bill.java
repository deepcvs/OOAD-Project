import java.util.*;

public class Bill {
    protected int id;
    private List<Dish> list_of_dishes;

    public Bill(List<Dish> list_of_dishes) {
        this.list_of_dishes = list_of_dishes;
    }

    private int GetCost() {
        for (Dish dish : list_of_dishes) {
            System.out.println(dish);
        }
        int sum = 0;
        for (Dish dish : list_of_dishes) {
            try {
                sum += Integer.parseInt(dish.price);
            } catch (NumberFormatException e) {
                System.err.println(e);
            }
        }

        return sum;
    }

    public int ShowCost() {
        System.out.println(GetCost());
        return GetCost();
    }
}
