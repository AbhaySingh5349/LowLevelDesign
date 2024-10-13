package Questions.CoffeeMachine.strategy.outlet;

import Questions.CoffeeMachine.enums.BeverageType;
import Questions.CoffeeMachine.model.Outlet;

import java.util.List;

public interface IOutletPickingStrategy<T> {
    Outlet getAvailableOutlet(T data);
}
