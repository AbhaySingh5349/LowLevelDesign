package Questions.CoffeeMachine.strategy.validations;

import Questions.CoffeeMachine.model.Outlet;
import Questions.CoffeeMachine.strategy.outlet.IOutletServiceStrategy;

import java.util.List;

public class FreeOutletValidation implements IValidationStrategy<List<Outlet>> {
    private final IOutletServiceStrategy<List<Outlet>> outletService;

    public FreeOutletValidation(IOutletServiceStrategy<List<Outlet>> outletService) {
        this.outletService = outletService;
    }

    @Override
    public boolean validate(List<Outlet> outlets) {
        // here we are checking outlet availability based on strategy (as outlet pipes can be different for hot & cool drinks)
        return outletService.checkAvailableOutlet(outlets);
    }
}
