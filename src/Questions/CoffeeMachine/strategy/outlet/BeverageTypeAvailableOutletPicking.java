package Questions.CoffeeMachine.strategy.outlet;

import Questions.CoffeeMachine.dto.BeverageTypeOutletValidationData;
import Questions.CoffeeMachine.enums.BeverageType;
import Questions.CoffeeMachine.model.Outlet;

import java.util.List;

public class BeverageTypeAvailableOutletPicking implements IOutletPickingStrategy<BeverageTypeOutletValidationData>{
    @Override
    public Outlet getAvailableOutlet(BeverageTypeOutletValidationData data) {
        List<Outlet> outlets = data.getOutlets();
        BeverageType beverageType = data.getBeverageType();

        return null;
    }
}
