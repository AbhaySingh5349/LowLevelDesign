package Questions.OrderManagementSystem.repository;

import Questions.OrderManagementSystem.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryProductRepo implements IProductRepo{
    private Map<String, Product> productMap;

    public InMemoryProductRepo() {
        this.productMap = new HashMap<>();
    }

    @Override
    public void add(Product product) {
        String id = product.getId();
        productMap.put(id, product);
    }

    @Override
    public Product getProductById(String productId) {
        return productMap.get(productId);
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(productMap.values());
    }
}
