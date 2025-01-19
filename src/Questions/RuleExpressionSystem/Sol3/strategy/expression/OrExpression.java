package Questions.RuleExpressionSystem.Sol3.strategy.expression;

public class OrExpression implements IExpression{
    private final IExpression leftExpression;
    private final IExpression rightExpression;

    public OrExpression(IExpression leftExpression, IExpression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public String buildRule() {
        return String.format("{\"any\": [%s, %s]}", leftExpression.buildRule(), rightExpression.buildRule());
    }
}
