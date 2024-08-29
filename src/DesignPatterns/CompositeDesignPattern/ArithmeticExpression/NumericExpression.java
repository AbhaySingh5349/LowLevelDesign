package DesignPatterns.CompositeDesignPattern.ArithmeticExpression;

public class NumericExpression implements Expression{
    Integer value;

    public NumericExpression(Integer value) {
        this.value = value;
    }

    @Override
    public Integer solve() {
        return value;
    }
}
