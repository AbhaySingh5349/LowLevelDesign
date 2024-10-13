package Questions.CoffeeMachine.strategy.validations;

import Questions.CoffeeMachine.dto.PriceValidationData;
import Questions.CoffeeMachine.enums.BeverageType;
import Questions.CoffeeMachine.enums.Bill;
import Questions.CoffeeMachine.model.Beverage;

import java.util.List;
import java.util.Map;

public class PriceValidation implements IValidationStrategy<PriceValidationData> {
    private final Map<BeverageType, Beverage> beverageTypeMap;

    public PriceValidation(Map<BeverageType, Beverage> beverageTypeMap) {
        this.beverageTypeMap = beverageTypeMap;
    }

    @Override
    public boolean validate(PriceValidationData data) {
        BeverageType beverageType = data.getBeverageType();
        List<Bill> bills = data.getBills();

        int price = beverageTypeMap.get(beverageType).getPrice();
        int paidByUser = bills.stream().mapToInt(Bill::getValue).sum();

        return paidByUser >= price;
    }
}
