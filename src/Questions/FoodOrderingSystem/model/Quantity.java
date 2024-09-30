package Questions.FoodOrderingSystem.model;

import Questions.FoodOrderingSystem.enums.QuantityUnit;

public class Quantity {
    private final Integer value;
    private final QuantityUnit unit;

    public Quantity(Integer value, QuantityUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Integer getValue() {
        return value;
    }

    public QuantityUnit getUnit() {
        return unit;
    }

    public boolean isAvailable(){
        return value > 0;
    }
}
