package Questions.OrderManagementSystem.repository;

import java.util.Timer;

public interface IReservationRepo {
    void addOrderTimer(String orderId, Timer timer);
    Timer getOrderTimer(String orderId);
    void removeOrderTimer(String orderId);
}
