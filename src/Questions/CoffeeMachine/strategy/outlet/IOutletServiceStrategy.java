package Questions.CoffeeMachine.strategy.outlet;

import Questions.CoffeeMachine.model.Outlet;

public interface IOutletServiceStrategy<T> {
    boolean checkAvailableOutlet(T data);
    Outlet getAvailableOutlet(T data);
}
