package Questions.CoffeeMachine.states;

import Questions.CoffeeMachine.dto.BeverageTypeOutletValidationData;
import Questions.CoffeeMachine.dto.PriceValidationData;
import Questions.CoffeeMachine.enums.BeverageType;
import Questions.CoffeeMachine.enums.Bill;
import Questions.CoffeeMachine.enums.OutletStatus;
import Questions.CoffeeMachine.model.*;
import Questions.CoffeeMachine.service.BeverageTypeOutletService;
import Questions.CoffeeMachine.strategy.outlet.IOutletServiceStrategy;
import Questions.CoffeeMachine.service.NormalSelectOutletService;
import Questions.CoffeeMachine.strategy.validations.*;

import java.util.List;
import java.util.Map;

public class SelectionState implements IState{
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
        /*
        // get Beverage details
        Map<BeverageType, Beverage> beverageTypeMap = machine.getBeverageTypeMap();
        Beverage beverage = beverageTypeMap.get(beverageType);

        int price = beverage.getPrice();

        // total amount paid by User
        List<Bill> bills = machine.getBills();
        int paidByUser = bills.stream().mapToInt(Bill::getValue).sum();
        if(paidByUser < price){
            getRefund(machine);
            return;
        }else{
            if(paidByUser > price){
                getChange(paidByUser - price);
            }
        }

        // check if sufficient inventory is available
        Inventory inventory = machine.getInventory();
        List<Ingredient> requiredIngredients = beverage.getRequiredIngredients();
        for(Ingredient reqIngredient : requiredIngredients){
            if(!inventory.checkIfSufficientInventoryAvailable(reqIngredient)){
                throw new RuntimeException("ingredient not in sufficient quantity");
            }
        }
         */

        Map<BeverageType, Beverage> beverageTypeMap = machine.getBeverageTypeMap();
        List<Outlet> outlets = machine.getOutlets();
        Beverage beverage = beverageTypeMap.get(beverageType);
        List<Ingredient> requiredIngredients = beverage.getRequiredIngredients();
        IOutletServiceStrategy<?> outletService = machine.getOutletService();
        Inventory inventory = machine.getInventory();

        List<IValidationStrategy<?>> validations = machine.getValidations();
        boolean isValid = validations.stream().allMatch(validation -> {
            if (validation instanceof IngredientValidation) {
                return  ((IngredientValidation) validation).validate(requiredIngredients);
            } else if (validation instanceof BatteryValidation) {
                return ((BatteryValidation) validation).validate(100);
            } else if (validation instanceof PriceValidation) {
                PriceValidationData priceValidationData = new PriceValidationData(beverageType, machine.getBills());
                return  ((PriceValidation) validation).validate(priceValidationData);
            }else if(validation instanceof FreeOutletValidation){
                return ((FreeOutletValidation) validation).validate(outlets);
            }
            return true;  // In case no validation applies, default to true
        });

        if (!isValid) {
            throw new RuntimeException("Validations failed for brewing beverage");
        }

        // outlet availability
        Outlet outlet = null;
        if(outletService instanceof NormalSelectOutletService){
            outlet = ((NormalSelectOutletService) outletService).getAvailableOutlet(outlets);
        }else if(outletService instanceof BeverageTypeOutletService){
            BeverageTypeOutletValidationData beverageTypeOutletValidationData = new BeverageTypeOutletValidationData(outlets, beverageType);
            outlet = ((BeverageTypeOutletService) outletService).getAvailableOutlet(beverageTypeOutletValidationData);
        }

        if(outlet == null){
            throw new RuntimeException("No Free outlet");
        }
        outlet.setStatus(OutletStatus.SERVING);

        // update inventory
        inventory.reduceInventory(requiredIngredients);

        machine.setState(new DispenseState(outlet, beverage));
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
        return;
    }
}
