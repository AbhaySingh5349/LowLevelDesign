package Questions.FoodOrderingSystem.model;

import Questions.FoodOrderingSystem.enums.Currency;

public class Price {
    public Double getValue() {
        return value;
    }

    public Currency getCurrency() {
        return currency;
    }

    private final Double value;
    private final Currency currency;

    public Price(Double value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }
}
