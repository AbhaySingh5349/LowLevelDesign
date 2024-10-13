package Questions.CoffeeMachine.dto;

import Questions.CoffeeMachine.enums.BeverageType;
import Questions.CoffeeMachine.model.Outlet;

import java.util.List;

public class BeverageTypeOutletValidationData {
    private final List<Outlet> outlets;
    private final BeverageType beverageType;

    public BeverageTypeOutletValidationData(List<Outlet> outlets, BeverageType beverageType) {
        this.outlets = outlets;
        this.beverageType = beverageType;
    }

    public List<Outlet> getOutlets() {
        return outlets;
    }

    public BeverageType getBeverageType() {
        return beverageType;
    }
}
