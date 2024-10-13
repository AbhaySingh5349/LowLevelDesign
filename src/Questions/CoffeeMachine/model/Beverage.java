package Questions.CoffeeMachine.model;

import Questions.CoffeeMachine.enums.BeverageType;
import Questions.CoffeeMachine.strategy.recipe.IRecipeStepStrategy;

import java.util.List;

public class Beverage {
    BeverageType beverageType;
    List<Ingredient> requiredIngredients;
    int price;
    private final List<IRecipeStepStrategy> recipeSteps;

    public Beverage(BeverageType beverageType, List<Ingredient> requiredIngredients, int price, List<IRecipeStepStrategy> recipeSteps) {
        this.beverageType = beverageType;
        this.requiredIngredients = requiredIngredients;
        this.price = price;
        this.recipeSteps = recipeSteps;
    }

    public BeverageType getBeverageType() {
        return beverageType;
    }

    public List<Ingredient> getRequiredIngredients() {
        return requiredIngredients;
    }

    public int getPrice() {
        return price;
    }

    public void prepare(){
        recipeSteps.forEach(IRecipeStepStrategy::execute);
    }
}
