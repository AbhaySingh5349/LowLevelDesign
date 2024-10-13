package Questions.CoffeeMachine.model;

public class Ingredient {
    private final String name;
    private final Quantity quantity;

    public Ingredient(String name, Quantity quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public Boolean isMoreThan(Ingredient other){
        if(this.quantity.isMoreThan(other.quantity)){
            return true;
        }
        return false;
    }
}
