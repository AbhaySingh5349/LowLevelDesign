package Questions.AdvanceConditionalFilter.strategy.attribute_operator;

import Questions.AdvanceConditionalFilter.enums.Operator;

import java.util.List;

public class ColorAttributeOperator implements IAttributeOperatorStrategy{
    @Override
    public boolean isOperatorValid(Operator operator, Object value) {
        if (!(value instanceof String)){
            if (operator == Operator.IN && value instanceof List) {
                List<?> valueList = (List<?>) value;
                return valueList.stream().allMatch(v -> v instanceof String);
            }
            return false;
        }

        return operator == Operator.EQUALS ||
                operator == Operator.CONTAINS ||
                operator == Operator.STARTS_WITH ||
                operator == Operator.ENDS_WITH ||
                operator == Operator.IN;
    }
}
