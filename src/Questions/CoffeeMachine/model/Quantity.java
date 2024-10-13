package Questions.CoffeeMachine.model;

import Questions.CoffeeMachine.enums.QuantityUnit;

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

    Boolean isMoreThan(Quantity other){
        if(this.unit != other.unit){
            throw new RuntimeException("Units don't match for quantities");
        }
        return this.value >= other.value;
    }
}
