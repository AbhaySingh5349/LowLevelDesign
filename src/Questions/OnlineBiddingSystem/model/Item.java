package Questions.OnlineBiddingSystem.model;

import Questions.OnlineBiddingSystem.enums.ItemCategory;

public class Item {
    private final String name;
    private final ItemCategory category;
    private final int basePrice;


    public Item(String name, ItemCategory category, int basePrice) {
        this.name = name;
        this.category = category;
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public int getBasePrice() {
        return basePrice;
    }
}
