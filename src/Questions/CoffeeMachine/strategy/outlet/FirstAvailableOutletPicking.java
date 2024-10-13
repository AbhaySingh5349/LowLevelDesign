package Questions.CoffeeMachine.strategy.outlet;

import Questions.CoffeeMachine.enums.BeverageType;
import Questions.CoffeeMachine.enums.OutletStatus;
import Questions.CoffeeMachine.model.Outlet;

import java.util.List;

public class FirstAvailableOutletPicking implements IOutletPickingStrategy<List<Outlet>> {
    @Override
    public Outlet getAvailableOutlet(List<Outlet> outlets) {
        return outlets.stream().filter(o -> o.getStatus().equals(OutletStatus.IDEAL)).findFirst().orElse(null);
    }
}
