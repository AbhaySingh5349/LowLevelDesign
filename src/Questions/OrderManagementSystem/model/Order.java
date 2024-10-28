package Questions.OrderManagementSystem.model;

import Questions.OrderManagementSystem.enums.OrderStatus;

import java.util.List;

public class Order {
    private final String id;
    private final List<OrderItem> orderItems;
    private OrderStatus status;

    public Order(String id, List<OrderItem> orderItems) {
        this.id = id;
        this.orderItems = orderItems;
        this.status = OrderStatus.PLACED;
    }

    public String getId() {
        return id;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
