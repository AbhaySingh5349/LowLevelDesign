package DesignPatterns.StateDesignPattern.VMStates;

import DesignPatterns.StateDesignPattern.Item;
import DesignPatterns.StateDesignPattern.VendingMachine;
import DesignPatterns.StateDesignPattern.enums.Bill;

import java.util.List;

public interface State {
    public void clickOnInsertBillButton(VendingMachine machine) throws Exception;

    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception;

    public void insertBill(VendingMachine machine , Bill bill) throws Exception;

    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception;

    public int getChange(int returnChangeMoney) throws Exception;

    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception;

    public List<Bill> refundFullMoney(VendingMachine machine) throws Exception;

    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception;

}
