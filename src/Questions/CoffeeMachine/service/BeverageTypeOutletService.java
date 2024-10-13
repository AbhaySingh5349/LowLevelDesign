package Questions.CoffeeMachine.service;

import Questions.CoffeeMachine.dto.BeverageTypeOutletValidationData;
import Questions.CoffeeMachine.model.Outlet;
import Questions.CoffeeMachine.strategy.outlet.IOutletPickingStrategy;
import Questions.CoffeeMachine.strategy.outlet.IOutletServiceStrategy;

public class BeverageTypeOutletService implements IOutletServiceStrategy<BeverageTypeOutletValidationData> {
    private final IOutletPickingStrategy<BeverageTypeOutletValidationData> outletPickingStrategy;

    public BeverageTypeOutletService(IOutletPickingStrategy<BeverageTypeOutletValidationData> outletPickingStrategy) {
        this.outletPickingStrategy = outletPickingStrategy;
    }

    @Override
    public boolean checkAvailableOutlet(BeverageTypeOutletValidationData data) {
        return outletPickingStrategy.getAvailableOutlet(data) != null;
    }

    @Override
    public Outlet getAvailableOutlet(BeverageTypeOutletValidationData data) {
        return outletPickingStrategy.getAvailableOutlet(data);
    }
}
