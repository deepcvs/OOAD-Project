public class Waiter {
    private int delivery_id;
    private int table_number;

    public Waiter(int delivery_id, int table_number) {
        this.delivery_id = delivery_id;
        this.table_number = table_number;
    }

    public void Deliver() {
        // TODO implement here
        System.out.println("Delivery number " + delivery_id + " delivered to table number " + table_number);
    }
}
