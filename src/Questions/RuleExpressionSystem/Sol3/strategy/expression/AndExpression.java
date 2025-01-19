package Questions.RuleExpressionSystem.Sol3.strategy.expression;

public class AndExpression implements IExpression{
    private final IExpression leftExpression;
    private final IExpression rightExpression;

    public AndExpression(IExpression leftExpression, IExpression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public String buildRule() {
        return String.format("{\"all\": [%s, %s]}", leftExpression.buildRule(), rightExpression.buildRule());
    }
}
