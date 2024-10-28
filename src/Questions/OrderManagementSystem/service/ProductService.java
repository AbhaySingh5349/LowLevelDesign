package Questions.OrderManagementSystem.service;

import Questions.OrderManagementSystem.model.Product;
import Questions.OrderManagementSystem.repository.IProductRepo;

import java.util.List;

public class ProductService {
    private final IProductRepo productRepo;

    public ProductService(IProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public void add(Product product){
        productRepo.add(product);
    }

    public Product getProductById(String productId){
        return productRepo.getProductById(productId);
    }

    public List<Product> getAllProducts(){
        return productRepo.getAllProducts();
    }
}
