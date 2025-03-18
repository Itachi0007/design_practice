import java.util.*;



class Order {
    String orderId;
    String entryTime; // Store time as HH:mm for simplicity

    public Order(String orderId, String entryTime) {
        this.orderId = orderId;
        this.entryTime = entryTime;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId='" + orderId + "', entryTime='" + entryTime + "'}";
    }
}

/* TIME COMPLEXITY
• Insertion into TreeMap: O(log N) (Balanced Red-Black Tree)
• Search using subMap(): O(log N) + O(K) (where K is the number of results)
• Overall Complexity: O(log N + K)
*/

class OrderSearchSystem {
    // using TreeMap because stores keys in sorted order,
    // making it easy to access data in chronological order.
    private TreeMap<String, Order> orderMap;

    public OrderSearchSystem() {
        orderMap = new TreeMap<>();
    }

    public void addOrder(Order order) {
        orderMap.put(order.entryTime, order); // Store orders sorted by entry time
    }

    public Collection<Order> search(String startTime, String endTime) {
        return orderMap.subMap(startTime, true, endTime, true).values();
    }
}

public class OrderProblem {
    public static void main(String[] args) {
        OrderSearchSystem orderSystem = new OrderSearchSystem();

        // Adding sample orders
        orderSystem.addOrder(new Order("0124", "10:15"));
        orderSystem.addOrder(new Order("0345", "09:15"));
        orderSystem.addOrder(new Order("0873", "13:30"));
        orderSystem.addOrder(new Order("0314", "07:30"));

        // Searching for orders between 09:00 and 12:00
        Collection<Order> result = orderSystem.search("09:00", "12:00");

        // Display results
        System.out.println("Orders in the given time range: " + result);
    }
}