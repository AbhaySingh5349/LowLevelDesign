package Questions.RuleExpressionSystem.Sol2.strategy;

import Questions.RuleExpressionSystem.Sol2.enums.DataType;
import Questions.RuleExpressionSystem.Sol2.enums.Operator;

public class ConditionExpression implements Expression{
    private final String field;
    private final Operator operator;
    private final Object value;
    private final DataType dataType;

    public ConditionExpression(String field, Operator operator, Object value, DataType dataType) {
        if (!operator.isValidForType(dataType)) {
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
