package Questions.AdvanceConditionalFilter.model;

import Questions.AdvanceConditionalFilter.enums.SizeAttribute;

public class Product {
    private final String brand;
    private final String category;
    private final double price;
    private final double rating;
    private final String color;
    private final SizeAttribute size;
    private final boolean availability;

    public Product(String brand, String category, double price, double rating, String color, SizeAttribute size, boolean availability) {
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.rating = rating;
        this.color = color;
        this.size = size;
        this.availability = availability;
    }

    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public String getColor() {
        return color;
    }

    public SizeAttribute getSize() {
        return size;
    }

    public boolean isAvailability() {
        return availability;
    }

    @Override
    public String toString() {
        return "Product{" +
                "brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", color='" + color + '\'' +
                ", size=" + size +
                ", availability=" + availability +
                '}';
    }
}
