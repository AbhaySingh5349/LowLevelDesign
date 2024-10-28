package Questions.OrderManagementSystem.repository;

import Questions.OrderManagementSystem.enums.OrderStatus;
import Questions.OrderManagementSystem.model.Order;

import java.util.*;

public class InMemoryOrderRepo implements IOrderRepo{
    private final Map<String, Order> orders;

    public InMemoryOrderRepo() {
        this.orders = new HashMap<>();
    }

    @Override
    public void addOrder(Order order) {
        String id = order.getId();
        orders.put(id, order);
    }

    @Override
    public Order getOrderById(String orderId) {
        return orders.get(orderId);
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orders.values());
    }

    @Override
    public void updateOrderStatus(String orderId, OrderStatus status) {
        orders.get(orderId).setStatus(status);
    }
}
