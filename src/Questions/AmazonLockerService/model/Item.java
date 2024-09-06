package Questions.AmazonLockerService.model;

import Questions.AmazonLockerService.enums.Size;

public class Item {
    private String itemId;
    private String name;
    private double weight; // in kilograms

    public Item(String itemId, String name, double weight) {
        this.itemId = itemId;
        this.name = name;
        this.weight = weight;
    }

    // Getters and setters
    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }
}
