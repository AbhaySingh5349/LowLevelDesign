package Questions.OrderManagementSystem.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

public class InMemoryReservationRepo implements IReservationRepo{
    private final Map<String, Timer> reservationTimers;

    public InMemoryReservationRepo() {
        this.reservationTimers = new HashMap<>();
    }

    @Override
    public void addOrderTimer(String orderId, Timer timer) {
        reservationTimers.put(orderId, timer);
    }

    @Override
    public Timer getOrderTimer(String orderId) {
        return reservationTimers.get(orderId);
    }

    @Override
    public void removeOrderTimer(String orderId) {
        reservationTimers.remove(orderId);
    }
}
