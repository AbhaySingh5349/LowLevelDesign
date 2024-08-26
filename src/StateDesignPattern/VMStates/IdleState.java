package StateDesignPattern.VMStates;

import StateDesignPattern.Item;
import StateDesignPattern.VendingMachine;
import StateDesignPattern.enums.Bill;

import java.util.ArrayList;
import java.util.List;

public class IdleState implements State{
    public IdleState(){
        System.out.println("Currently Vending machine is in IdleState");
    }

    public IdleState(VendingMachine machine){
        System.out.println("Currently Vending machine is in IdleState");
        machine.setBillList(new ArrayList<>());
    }

    @Override
    public void clickOnInsertBillButton(VendingMachine machine) throws Exception {
        machine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        throw new Exception("first you need to click on insert bill button");
    }

    @Override
    public void insertBill(VendingMachine machine, Bill bill) throws Exception {
        throw new Exception("you can not insert Bill in idle state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("you can not choose Product in idle state");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("you can not get change in idle state");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("proeduct can not be dispensed idle state");
    }

    @Override
    public List<Bill> refundFullMoney(VendingMachine machine) throws Exception {
        throw new Exception("you can not get refunded in idle state");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        machine.getInventory().addItem(item, codeNumber);
    }
}
