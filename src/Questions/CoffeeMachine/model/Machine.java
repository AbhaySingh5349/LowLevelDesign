package Questions.CoffeeMachine.model;

import Questions.CoffeeMachine.enums.BeverageType;
import Questions.CoffeeMachine.enums.Bill;
import Questions.CoffeeMachine.states.IState;
import Questions.CoffeeMachine.strategy.outlet.IOutletServiceStrategy;
import Questions.CoffeeMachine.strategy.validations.IValidationStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Machine {
    Inventory inventory;
    Map<BeverageType, Beverage> beverageTypeMap;
    IState state;
    List<Bill> bills;
    List<Outlet> outlets;
    List<IValidationStrategy<?>> validations;
    IOutletServiceStrategy<?> outletService;

    public Machine(Inventory inventory, Map<BeverageType, Beverage> beverageTypeMap, IState state, List<Outlet> outlets, List<IValidationStrategy<?>> validations, IOutletServiceStrategy<?> outletService) {
        this.inventory = inventory;
        this.beverageTypeMap = beverageTypeMap;
        this.state = state;
        this.bills = new ArrayList<>();
        this.outlets = outlets;
        this.validations = validations;
        this.outletService = outletService;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Map<BeverageType, Beverage> getBeverageTypeMap() {
        return beverageTypeMap;
    }

    public List<BeverageType> getBeverageTypes() {
        return new ArrayList<>(beverageTypeMap.keySet());
    }

    public IState getState() {
        return state;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public List<Outlet> getOutlets() {
        return outlets;
    }

    public List<IValidationStrategy<?>> getValidations() {
        return validations;
    }

    public IOutletServiceStrategy<?> getOutletService() {
        return outletService;
    }

    public void setState(IState state) {
        this.state = state;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }
}
