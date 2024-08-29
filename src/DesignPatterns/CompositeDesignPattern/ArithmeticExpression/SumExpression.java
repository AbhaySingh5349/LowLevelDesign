package DesignPatterns.CompositeDesignPattern.ArithmeticExpression;

public class SumExpression implements Expression{
    Expression leftExpression;
    Expression rightExpression;

    public SumExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public Integer solve() {
        return leftExpression.solve() + rightExpression.solve();
    }
}
