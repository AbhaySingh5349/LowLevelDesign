package Questions.OrderManagementSystem.repository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryInventoryRepo implements IInventoryRepo{
    private final Map<String, Integer> inventoryMap;

    public InMemoryInventoryRepo() {
        this.inventoryMap = new HashMap<>();
    }

    @Override
    public void add(String productId, int count) {
        inventoryMap.put(productId, inventoryMap.getOrDefault(productId, 0) + count);
    }

    @Override
    public void remove(String productId) {
        inventoryMap.remove(productId);
    }

    @Override
    public void reduce(String productId, int count) {
        inventoryMap.put(productId, inventoryMap.getOrDefault(productId, 0) - count);
    }

    @Override
    public int getInventoryForProduct(String productId) {
        return inventoryMap.getOrDefault(productId, 0);
    }

    @Override
    public void display(){
        for (Map.Entry<String, Integer> entry : inventoryMap.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
