package Questions.RuleExpressionSystem.Sol2.strategy;

public class AndExpression implements Expression{
    private final Expression leftExpression;
    private final Expression rightExpression;

    public AndExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public String buildRule() {
        return String.format("{\"all\": [%s, %s]}", leftExpression.buildRule(), rightExpression.buildRule());
    }
}
