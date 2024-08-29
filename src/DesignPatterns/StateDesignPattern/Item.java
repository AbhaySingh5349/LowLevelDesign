package DesignPatterns.StateDesignPattern;

import DesignPatterns.StateDesignPattern.enums.ItemType;

public class Item {
    ItemType type;
    int price;

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}