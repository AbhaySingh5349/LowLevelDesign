package Questions.AdvanceConditionalFilter.strategy.attribute_operator;

import Questions.AdvanceConditionalFilter.enums.Operator;

import java.util.List;

public class PriceAttributeOperator implements IAttributeOperatorStrategy{
    @Override
    public boolean isOperatorValid(Operator operator, Object value) {
        if (!(value instanceof Number)) {
            // If it's BETWEEN operator, value should be a list of 2 Numbers
            if (operator == Operator.BETWEEN && value instanceof List) {
                List<?> valueList = (List<?>) value;
                return valueList.size() == 2 &&
                        valueList.get(0) instanceof Number &&
                        valueList.get(1) instanceof Number;
            }
            return false;
        }

        return operator == Operator.GREATER_THAN ||
                operator == Operator.LESS_THAN ||
                operator == Operator.EQUALS ||
                operator == Operator.GREATER_THAN_OR_EQUALS ||
                operator == Operator.LESS_THAN_OR_EQUALS ||
                operator == Operator.BETWEEN;
    }
}
