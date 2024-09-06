package Questions.AmazonLockerService.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Order {
    private String orderId;
    private List<Item> items;
    private Package pkg;
    private String lockerCode;
    private LocalDateTime deliveryTime;

    public Order(List<Item> items) {
        this.orderId = UUID.randomUUID().toString();
        this.items = items;
        this.pkg = new Package(items);
    }

    // Getters and setters
    public String getOrderId() {
        return orderId;
    }

    public List<Item> getItems() {
        return items;
    }

    public Package getPkg() {
        return pkg;
    }

    public String getLockerCode() {
        return lockerCode;
    }

    public void setLockerCode(String lockerCode) {
        this.lockerCode = lockerCode;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
}
