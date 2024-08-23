package CompositeDesignPattern.ArithmeticExpression;

public class MultiplyExpression implements Expression{
    Expression leftExpression;
    Expression rightExpression;

    public MultiplyExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public Integer solve() {
        return leftExpression.solve() * rightExpression.solve();
    }
}
