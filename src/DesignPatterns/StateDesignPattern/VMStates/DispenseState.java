package DesignPatterns.StateDesignPattern.VMStates;

import DesignPatterns.StateDesignPattern.Item;
import DesignPatterns.StateDesignPattern.VendingMachine;
import DesignPatterns.StateDesignPattern.enums.Bill;

import java.util.List;

public class DispenseState implements State{
    DispenseState(VendingMachine machine, int codeNumber) throws Exception{
        System.out.println("Currently Vending machine is in DispenseState");
        dispenseProduct(machine, codeNumber);
    }

    @Override
    public void clickOnInsertBillButton(VendingMachine machine) throws Exception {
        throw new Exception("insert coin button can not clicked on Dispense state");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        throw new Exception("product selection buttion can not be clicked in Dispense state");
    }

    @Override
    public void insertBill(VendingMachine machine, Bill bill) throws Exception {
        throw new Exception("bill cannot be inserted in Dispense state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("product cannot be choosen in Dispense state");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("change can not returned in Dispense state");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        System.out.println("Product has been dispensed");
        Item item = machine.getInventory().getItem(codeNumber);
        machine.getInventory().updateSoldOutItem(codeNumber);
        machine.setVendingMachineState(new IdleState(machine));
        return item;
    }

    @Override
    public List<Bill> refundFullMoney(VendingMachine machine) throws Exception {
        throw new Exception("refund can not be happen in Dispense state");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        throw new Exception("inventory can not be updated in Dispense state");
    }
}