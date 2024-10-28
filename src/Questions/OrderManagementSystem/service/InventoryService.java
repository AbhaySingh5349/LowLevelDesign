package Questions.OrderManagementSystem.service;

import Questions.OrderManagementSystem.repository.IInventoryRepo;

public class InventoryService {
    private final IInventoryRepo inventoryRepo;

    public InventoryService(IInventoryRepo inventoryRepo) {
        this.inventoryRepo = inventoryRepo;
    }

    public void add(String productId, int count){
        inventoryRepo.add(productId, count);
    }

    public void remove(String productId){
        inventoryRepo.remove(productId);
    }

    public void reduce(String productId, int count){
        inventoryRepo.reduce(productId, count);
    }

    public int getInventoryForProduct(String productId){
        return inventoryRepo.getInventoryForProduct(productId);
    }

    public void display(){
        inventoryRepo.display();
    }
}
