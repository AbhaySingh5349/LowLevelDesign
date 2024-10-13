package Questions.CoffeeMachine.states;

import Questions.CoffeeMachine.enums.BeverageType;
import Questions.CoffeeMachine.enums.Bill;
import Questions.CoffeeMachine.enums.OutletStatus;
import Questions.CoffeeMachine.model.Beverage;
import Questions.CoffeeMachine.model.Machine;
import Questions.CoffeeMachine.model.Outlet;

import java.util.ArrayList;
import java.util.List;

public class DispenseState implements IState{
    private final Outlet outlet;
    private final Beverage beverage;

    public DispenseState(Outlet outlet, Beverage beverage) {
        this.outlet = outlet;
        this.beverage = beverage;
    }

    @Override
    public void clickOnInsertBillButton(Machine machine) {
        return;
    }

    @Override
    public void insertBill(Machine machine, Bill bill) {
        return;
    }

    @Override
    public void clickOnBeverageSelectionButton(Machine machine) {
        return;
    }

    @Override
    public void chooseBeverage(Machine machine, BeverageType beverageType) {
        return;
    }

    @Override
    public int getChange(int extraMoney) {
        return 0;
    }

    @Override
    public List<Bill> getRefund(Machine machine) {
        return new ArrayList<>();
    }

    @Override
    public void dispenseBeverage(Machine machine) {
        beverage.prepare();
        outlet.setStatus(OutletStatus.SERVING);

        machine.setState(new IdealState(machine));
        outlet.setStatus(OutletStatus.IDEAL);
    }
}
