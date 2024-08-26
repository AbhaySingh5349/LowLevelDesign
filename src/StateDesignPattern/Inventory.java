package StateDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<ItemShelf> inventory;

    Inventory(int itemCount) {
        this.inventory = new ArrayList<>();;
        initialEmptyInventory(itemCount);
    }

    public List<ItemShelf> getInventory() {
        return inventory;
    }

    public void setInventory(List<ItemShelf> inventory) {
        this.inventory = inventory;
    }

    public void initialEmptyInventory(int itemCount) {
        int startCode = 101;
        for (int i = 0; i < itemCount; i++) {
            ItemShelf space = new ItemShelf();
            space.setCode(startCode + i);
            space.setSoldOut(true);
            inventory.add(space);
        }
    }

    public void addItem(Item item, int codeNumber) throws Exception {
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.code == codeNumber) {
                if (itemShelf.isSoldOut()) {
                    itemShelf.item = item;
                    itemShelf.setSoldOut(false);
                } else {
                    throw new Exception("already item is present, you can not add item here");
                }
            }
        }
    }

    public Item getItem(int codeNumber) throws Exception {
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.code == codeNumber) {
                if (itemShelf.isSoldOut()) {
                    throw new Exception("item already sold out");
                } else {
                    return itemShelf.item;
                }
            }
        }
        throw new Exception("Invalid Code");
    }

    public void updateSoldOutItem(int codeNumber){
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.code == codeNumber) {
                itemShelf.setSoldOut(true);
            }
        }
    }
}
