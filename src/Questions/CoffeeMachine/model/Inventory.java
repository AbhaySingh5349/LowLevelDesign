package Questions.CoffeeMachine.model;

import java.util.List;

public class Inventory {
    private final List<Ingredient> ingredients;

    public Inventory(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public boolean checkIfSufficientInventoryAvailable(Ingredient requiredIngredient){
        Ingredient invIngredient = ingredients.stream()
                .filter(ingredient -> ingredient.getName().equals(requiredIngredient.getName()))
                .findFirst()
                .orElse(null);

        if(invIngredient == null){
//            throw new RuntimeException("unsupported ingredient");
            return false;
        }
        if(!invIngredient.isMoreThan(requiredIngredient)){
//            throw new RuntimeException("ingredient not in sufficient quantity");
            return false;
        }

        return true;
    }

    public void reduceInventory(List<Ingredient> requiredIngredients){

    }
}
