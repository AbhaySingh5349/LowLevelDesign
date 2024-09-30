package Questions.FoodOrderingSystem.model;

public class MenuItem {
    private String name;
    private Price price;
    private Quantity quantity;

    public boolean isAvailable(){
        return quantity.isAvailable();
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }

    public Quantity getQuantity() {
        return quantity;
    }
}
