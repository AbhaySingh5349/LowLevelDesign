package Questions.CoffeeMachine.dto;

import Questions.CoffeeMachine.enums.BeverageType;
import Questions.CoffeeMachine.enums.Bill;

import java.util.List;

public class PriceValidationData {
    private final BeverageType beverageType;
    private final List<Bill> bills;

    public PriceValidationData(BeverageType beverageType, List<Bill> bills) {
        this.beverageType = beverageType;
        this.bills = bills;
    }

    public BeverageType getBeverageType() {
        return beverageType;
    }

    public List<Bill> getBills() {
        return bills;
    }
}
