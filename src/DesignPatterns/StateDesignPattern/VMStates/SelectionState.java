package DesignPatterns.StateDesignPattern.VMStates;

import DesignPatterns.StateDesignPattern.Item;
import DesignPatterns.StateDesignPattern.VendingMachine;
import DesignPatterns.StateDesignPattern.enums.Bill;

import java.util.List;

public class SelectionState implements State{
    public SelectionState(){
        System.out.println("Currently Vending machine is in SelectionState");
    }

    @Override
    public void clickOnInsertBillButton(VendingMachine machine) throws Exception {
        throw new Exception("you can not click on insert coin button in Selection state");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        return;
    }

    @Override
    public void insertBill(VendingMachine machine, Bill bill) throws Exception {
        throw new Exception("you can not insert Bill in selection state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        //1. get item of this codeNumber
        Item item = machine.getInventory().getItem(codeNumber);

        //2. total amount paid by User
        int paidByUser = 0;
        for(Bill bill : machine.getBillList()){
            paidByUser = paidByUser + bill.value;
        }

        //3. compare product price and amount paid by user
        if(paidByUser < item.getPrice()) {
            System.out.println("Insufficient Amount, Product you selected is for price: " + item.getPrice() + " and you paid: " + paidByUser);
            refundFullMoney(machine);
            throw new Exception("insufficient amount");
        }
        else if(paidByUser >= item.getPrice()) {
            if(paidByUser > item.getPrice()) {
                getChange(paidByUser-item.getPrice());
            }
            machine.setVendingMachineState(new DispenseState(machine, codeNumber));
        }
    }

    @Override
    public int getChange(int returnExtraMoney) throws Exception {
        //actual logic should be to return COINs in the dispense tray, but for simplicity i am just returning the amount to be refunded
        System.out.println("Returned the change in the Coin Dispense Tray: " + returnExtraMoney);
        return returnExtraMoney;
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("product can not be dispensed Selection state");
    }

    @Override
    public List<Bill> refundFullMoney(VendingMachine machine) throws Exception {
        System.out.println("Returned the full amount back in the Coin Dispense Tray");
        machine.setVendingMachineState(new IdleState(machine));
        return machine.getBillList();
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        throw new Exception("Inventory cannot be updated in Selection state");
    }
}
