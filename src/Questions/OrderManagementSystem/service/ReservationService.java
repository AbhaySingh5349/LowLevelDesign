package Questions.OrderManagementSystem.service;

import Questions.OrderManagementSystem.enums.OrderStatus;
import Questions.OrderManagementSystem.model.Order;
import Questions.OrderManagementSystem.model.OrderItem;
import Questions.OrderManagementSystem.repository.IReservationRepo;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ReservationService {
    private final IReservationRepo reservationRepo;
    private final InventoryService inventoryService;
    private final int RESERVATION_TIMER_SECONDS = 10;

    public ReservationService(IReservationRepo reservationRepo, InventoryService inventoryService) {
        this.reservationRepo = reservationRepo;
        this.inventoryService = inventoryService;
    }

    public void startReservation(Order order){
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (order.getStatus() == OrderStatus.PLACED) {
                    unblockOrderItems(order);
                    order.setStatus(OrderStatus.CANCELLED);
                }
                cancelReservation(order.getId());
            }
        }, RESERVATION_TIMER_SECONDS * 1000);

        reservationRepo.addOrderTimer(order.getId(), timer);
    }

    public void cancelReservation(String orderId) {
        Timer timer = reservationRepo.getOrderTimer(orderId);
        if (timer != null) {
            timer.cancel();
            reservationRepo.removeOrderTimer(orderId);
        }
    }

    public void unblockOrderItems(Order order){
        List<OrderItem> items = order.getOrderItems();
        for (OrderItem item : items) {
            String productId = item.getProductId();
            int qty = item.getQuantity();

            inventoryService.add(productId, qty);
        }
    }
}
