import java.util.*;

public class Payment {
    private int id;
    private int amount;

    public Payment(int amount) {
        this.amount = amount;
    }

    public void PaymentDone() {
        System.out.println("Processing ...");
        System.out.println("Payment of " + amount + " Done");
        System.out.println("Visit Again !!!");
    }
}