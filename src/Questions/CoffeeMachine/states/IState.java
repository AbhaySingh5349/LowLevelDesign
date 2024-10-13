package Questions.CoffeeMachine.states;

import Questions.CoffeeMachine.enums.BeverageType;
import Questions.CoffeeMachine.enums.Bill;
import Questions.CoffeeMachine.model.Machine;

import java.util.List;

public interface IState {
    void clickOnInsertBillButton(Machine machine); // ideal state
    void insertBill(Machine machine , Bill bill); // has money state
    void clickOnBeverageSelectionButton(Machine machine); // has money state
    void chooseBeverage(Machine machine, BeverageType beverageType); // product selection state
    int getChange(int extraMoney); // product selection state
    List<Bill> getRefund(Machine machine); // product selection state
    void dispenseBeverage(Machine machine); // dispense state
}
