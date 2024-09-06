package Questions.AmazonLockerService.model;

import Questions.AmazonLockerService.service.LockerService;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String customerId;
    private final String name;
    private final List<Order> orders;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order, LockerLocation location, LockerService lockerService) {
        lockerService.assignLockerForOrder(order, location);
        orders.add(order);
    }

    public void pickupOrder(Order order, LockerService lockerService, String code) {
        lockerService.pickupOrder(order, code);
    }

    public void returnOrder(Order order, LockerLocation location, LockerService lockerService) {
        lockerService.returnOrder(order, location);
    }

    // Getters
    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
