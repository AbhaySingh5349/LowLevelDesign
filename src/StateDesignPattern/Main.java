package StateDesignPattern;

import StateDesignPattern.VMStates.State;
import StateDesignPattern.enums.Bill;
import StateDesignPattern.enums.ItemType;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        try {

            System.out.println("|");
            System.out.println("filling up the inventory");
            System.out.println("|");

            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);

            System.out.println("|");
            System.out.println("clicking on InsertCoinButton");
            System.out.println("|");

            State vendingState = vendingMachine.getVendingMachineState();
            vendingState.clickOnInsertBillButton(vendingMachine);

            vendingState = vendingMachine.getVendingMachineState();
            vendingState.insertBill(vendingMachine, Bill.TEN);
            vendingState.insertBill(vendingMachine, Bill.TWENTY);

            System.out.println("|");
            System.out.println("clicking on ProductSelectionButton");
            System.out.println("|");
            vendingState.clickOnStartProductSelectionButton(vendingMachine);

            vendingState = vendingMachine.getVendingMachineState();
            vendingState.chooseProduct(vendingMachine, 102);

            displayInventory(vendingMachine);

        }
        catch (Exception e){
            displayInventory(vendingMachine);
        }
    }

    private static void fillUpInventory(VendingMachine vendingMachine){
        List<ItemShelf> slots = vendingMachine.getInventory().getInventory();
        for (int i = 0; i < slots.size(); i++) {
            Item newItem = new Item();
            if(i<3) {
                newItem.setType(ItemType.COKE);
                newItem.setPrice(12);
            }else if(i<5){
                newItem.setType(ItemType.PEPSI);
                newItem.setPrice(9);
            }else if(i<7){
                newItem.setType(ItemType.JUICE);
                newItem.setPrice(13);
            }else if(i<10){
                newItem.setType(ItemType.SODA);
                newItem.setPrice(7);
            }
            slots.get(i).setItem(newItem);
            slots.get(i).setSoldOut(false);
        }
    }

    private static void displayInventory(VendingMachine vendingMachine){
        List<ItemShelf> slots = vendingMachine.getInventory().getInventory();
        for (int i = 0; i < slots.size(); i++) {

            System.out.println("CodeNumber: " + slots.get(i).getCode() +
                    " Item: " + slots.get(i).getItem().getType().name() +
                    " Price: " + slots.get(i).getItem().getPrice() +
                    " isAvailable: " + !slots.get(i).isSoldOut());
        }
    }

}
