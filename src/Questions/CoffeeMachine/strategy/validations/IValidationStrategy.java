package Questions.CoffeeMachine.strategy.validations;

public interface IValidationStrategy<T> {
    boolean validate(T data);
}
