package Questions.RuleExpressionSystem.Sol2.strategy;

public class OrExpression implements Expression{
    private final Expression leftExpression;
    private final Expression rightExpression;

    public OrExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public String buildRule() {
        return String.format("{\"any\": [%s, %s]}", leftExpression.buildRule(), rightExpression.buildRule());
    }
}
