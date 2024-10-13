package Questions.CoffeeMachine.states;

import Questions.CoffeeMachine.enums.BeverageType;
import Questions.CoffeeMachine.enums.Bill;
import Questions.CoffeeMachine.model.Machine;

import java.util.ArrayList;
import java.util.List;

public class HasMoneyState implements IState{
    @Override
    public void clickOnInsertBillButton(Machine machine) {
        return;
    }

    @Override
    public void insertBill(Machine machine, Bill bill) {
        machine.getBills().add(bill);
    }

    @Override
    public void clickOnBeverageSelectionButton(Machine machine) {
        machine.setState(new SelectionState());
    }

    @Override
    public void chooseBeverage(Machine machine, BeverageType beverageType) {
        return;
    }

    @Override
    public int getChange(int extraMoney) {
        return extraMoney;
    }

    @Override
    public List<Bill> getRefund(Machine machine) {
        List<Bill> bills = machine.getBills();
        machine.setState(new IdealState());
        return bills;
    }

    @Override
    public void dispenseBeverage(Machine machine) {

    }
}
