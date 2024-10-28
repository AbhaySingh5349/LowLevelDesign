package Questions.OrderManagementSystem.repository;

public interface IInventoryRepo {
    void add(String productId, int count);
    void remove(String productId);
    void reduce(String productId, int count);
    int getInventoryForProduct(String productId);
    void display();
}
