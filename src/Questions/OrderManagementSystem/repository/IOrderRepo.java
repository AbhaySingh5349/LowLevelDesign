package Questions.OrderManagementSystem.repository;

import Questions.OrderManagementSystem.enums.OrderStatus;
import Questions.OrderManagementSystem.model.Order;

import java.util.List;
import java.util.Timer;

public interface IOrderRepo {
    void addOrder(Order order);
    Order getOrderById(String orderId);
    List<Order> getAllOrders();
    void updateOrderStatus(String orderId, OrderStatus status);
}
