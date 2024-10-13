package Questions.CoffeeMachine.states;

import Questions.CoffeeMachine.enums.BeverageType;
import Questions.CoffeeMachine.enums.Bill;
import Questions.CoffeeMachine.model.Machine;

import java.util.ArrayList;
import java.util.List;

public class IdealState implements IState{
    public IdealState() {
        System.out.println("Machine is in Ideal State");
    }

    public IdealState(Machine machine){
        System.out.println("Currently Vending machine is in IdealState");
        machine.setBills(new ArrayList<>());
    }

    @Override
    public void clickOnInsertBillButton(Machine machine) {
        machine.setState(new HasMoneyState());
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
        return extraMoney;
    }

    @Override
    public List<Bill> getRefund(Machine machine) {
        return new ArrayList<>();
    }

    @Override
    public void dispenseBeverage(Machine machine) {
        return;
    }
}
