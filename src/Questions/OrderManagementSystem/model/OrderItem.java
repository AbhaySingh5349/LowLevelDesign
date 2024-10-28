package Questions.OrderManagementSystem.model;

public class OrderItem {
    private final String id;
    private final String productId;
    private final Integer quantity;

    public OrderItem(String id, String productId, Integer quantity) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id='" + id + '\'' +
                ", productId='" + productId + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
