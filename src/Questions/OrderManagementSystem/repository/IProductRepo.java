package Questions.OrderManagementSystem.repository;

import Questions.OrderManagementSystem.model.Product;

import java.util.List;

public interface IProductRepo {
    void add(Product product);
    Product getProductById(String productId);
    List<Product> getAllProducts();
}
