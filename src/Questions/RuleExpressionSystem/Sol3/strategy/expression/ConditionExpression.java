package Questions.RuleExpressionSystem.Sol3.strategy.expression;

import Questions.RuleExpressionSystem.Sol3.enums.DataType;
import Questions.RuleExpressionSystem.Sol3.enums.Operator;

public class ConditionExpression implements IExpression{
    private final String field;
    private final Operator operator;
    private final Object value;
    private final DataType dataType;

    public ConditionExpression(String field, Operator operator, Object value, DataType dataType) {
        if (!dataType.getStrategy().isOperatorValid(operator, value)) {
            throw new IllegalArgumentException(
                    String.format("Operator '%s' is not valid for data type '%s'", operator.getSymbol(), dataType)
            );
        }
        this.field = field;
        this.operator = operator;
        this.value = value;
        this.dataType = dataType;
    }

    @Override
    public String buildRule() {
        return String.format(
                "{\"field\": \"%s\", \"operator\": \"%s\", \"value\": \"%s\", \"dataType\": \"%s\"}",
                field, operator.getSymbol(), value.toString(), dataType.name()
        );
    }
}
