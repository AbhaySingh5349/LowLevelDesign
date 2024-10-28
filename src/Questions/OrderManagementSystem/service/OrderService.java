package Questions.OrderManagementSystem.service;

import Questions.OrderManagementSystem.enums.OrderStatus;
import Questions.OrderManagementSystem.model.Order;
import Questions.OrderManagementSystem.model.OrderItem;
import Questions.OrderManagementSystem.repository.IOrderRepo;

import java.util.List;

public class OrderService {
    private final IOrderRepo orderRepo;
    private final ReservationService reservationService;
    private final InventoryService inventoryService;

    public OrderService(IOrderRepo orderRepo, ReservationService reservationService, InventoryService inventoryService) {
        this.orderRepo = orderRepo;
        this.reservationService = reservationService;
        this.inventoryService = inventoryService;
    }

    public boolean placeOrder(Order order){
        List<OrderItem> items = order.getOrderItems();
        for(OrderItem item : items){
            int availableQty = inventoryService.getInventoryForProduct(item.getProductId());
            if(item.getQuantity() > availableQty){
                System.out.println("Insufficient stock for product " + item.getProductId() + " , available: " + availableQty);
                return false;
            }
        }

        for (OrderItem item : items) {
            String productId = item.getProductId();
            int qty = item.getQuantity();

            inventoryService.reduce(productId, qty);
        }

        orderRepo.addOrder(order);
        reservationService.startReservation(order);

        return true;
    }

    public void confirmOrder(String orderId) {
        Order order = orderRepo.getOrderById(orderId);
        List<OrderItem> items = order.getOrderItems();
        for (OrderItem item : items) {
            String productId = item.getProductId();
            int qty = item.getQuantity();

            inventoryService.reduce(productId, qty);
        }
    }
}
