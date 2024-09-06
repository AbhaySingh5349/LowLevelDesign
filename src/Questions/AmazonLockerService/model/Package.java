package Questions.AmazonLockerService.model;

import Questions.AmazonLockerService.enums.Size;

import java.util.List;
import java.util.UUID;

public class Package {
    private String packageId;
    private Size size;
    private List<Item> items;

    public Package(List<Item> items) {
        this.packageId = UUID.randomUUID().toString();
        this.items = items;
        this.size = calculateSize(items);
    }

    private Size calculateSize(List<Item> items) {
        // Simplified size calculation based on total weight
        double totalWeight = items.stream().mapToDouble(Item::getWeight).sum();
        if (totalWeight < 1) return Size.EXTRA_SMALL;
        if (totalWeight < 2) return Size.SMALL;
        if (totalWeight < 5) return Size.MEDIUM;
        if (totalWeight < 10) return Size.LARGE;
        if (totalWeight < 20) return Size.EXTRA_LARGE;
        return Size.DOUBLE_EXTRA_LARGE;
    }

    // Getters
    public String getPackageId() {
        return packageId;
    }

    public Size getSize() {
        return size;
    }

    public List<Item> getItems() {
        return items;
    }
}
