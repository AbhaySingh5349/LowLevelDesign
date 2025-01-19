package Questions.RuleExpressionSystem.Sol3.strategy.expression;

public class NotExpression implements IExpression{
    private final IExpression expression;

    public NotExpression(IExpression expression) {
        this.expression = expression;
    }

    @Override
    public String buildRule() {
        return String.format("{\"not\": %s}", expression.buildRule());
    }
}
