package Questions.CoffeeMachine.strategy.validations;

import Questions.CoffeeMachine.model.Ingredient;
import Questions.CoffeeMachine.model.Inventory;

import java.util.List;

public class IngredientValidation implements IValidationStrategy<List<Ingredient>> {
    private final Inventory inventory;

    public IngredientValidation(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public boolean validate(List<Ingredient> requiredIngredients) {
        return requiredIngredients.stream().allMatch(inventory::checkIfSufficientInventoryAvailable);
    }
}
