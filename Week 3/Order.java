public class Order {
    static int totalOrders = 0;

    public Order() {
        totalOrders++;
    }

    public static void main(String[] args) {
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        Order order4 = new Order();

        System.out.println("Total orders: " + Order.totalOrders);
    }
}
