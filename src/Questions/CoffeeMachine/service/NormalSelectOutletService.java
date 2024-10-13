package Questions.CoffeeMachine.service;

import Questions.CoffeeMachine.model.Outlet;
import Questions.CoffeeMachine.strategy.outlet.IOutletPickingStrategy;
import Questions.CoffeeMachine.strategy.outlet.IOutletServiceStrategy;

import java.util.List;

public class NormalSelectOutletService implements IOutletServiceStrategy<List<Outlet>> {
    private final IOutletPickingStrategy<List<Outlet>> outletPickingStrategy;

    public NormalSelectOutletService(IOutletPickingStrategy<List<Outlet>> outletPickingStrategy) {
        this.outletPickingStrategy = outletPickingStrategy;
    }

    @Override
    public boolean checkAvailableOutlet(List<Outlet> data) {
        return getAvailableOutlet(data) != null;
    }

    @Override
    public Outlet getAvailableOutlet(List<Outlet> data) {
        return outletPickingStrategy.getAvailableOutlet(data);
    }
}
