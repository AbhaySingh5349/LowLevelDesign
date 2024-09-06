package Questions.AmazonLockerService.service;

import DesignPatterns.ObserverDesignPattern.NotificationSystem;
import Questions.AmazonLockerService.model.Locker;
import Questions.AmazonLockerService.model.LockerLocation;
import Questions.AmazonLockerService.model.Order;
import Questions.AmazonLockerService.model.Package;
import Questions.AmazonLockerService.repository.LockerRepository;
import Questions.AmazonLockerService.strategy.LockerOpenState;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public class LockerService {
    private final LockerRepository lockerRepository;
    private final Random random = new Random();

    public LockerService(LockerRepository lockerRepository) {
        this.lockerRepository = lockerRepository;
    }

    public void assignLockerForOrder(Order order, LockerLocation location) {
        Package pkg = order.getPkg();

        synchronized (location){
            List<Locker> availableLockers = location.getAvailableLockers();
            for (Locker locker : availableLockers) {
                if (locker.getSize().ordinal() >= pkg.getSize().ordinal()) {
                    locker.assignPackage(pkg);
                    lockerRepository.saveLocker(locker);
                    String code = generateCode();
                    order.setLockerCode(code);
                    order.setDeliveryTime(LocalDateTime.now());
                    NotificationService.sendLockerCode(locker);
                    System.out.println("Assigned Locker " + locker.getLockerId() + " to Order " + order.getOrderId());
                    return;
                }
            }
            throw new IllegalStateException("No available locker for this package.");
        }
    }

    public void pickupOrder(Order order, String code) {
        Locker locker = lockerRepository.findLockerByPackage(order.getPkg());
        if (locker == null) {
            throw new IllegalStateException("Locker not found for this package.");
        }

        // Verify code (simplified)
        if (!order.getLockerCode().equals(code)) {
            throw new IllegalArgumentException("Invalid locker code.");
        }

        lockerRepository.saveLocker(locker);
        System.out.println("Order " + order.getOrderId() + " picked up successfully.");
    }

    public void returnOrder(Order order, LockerLocation location) {
        // Assign a new locker for the returned package
        assignLockerForOrder(order, location);
        System.out.println("Order " + order.getOrderId() + " returned successfully.");
    }

    private String generateCode() {
        int code = 100000 + random.nextInt(900000); // 6-digit code
        return String.valueOf(code);
    }
}
