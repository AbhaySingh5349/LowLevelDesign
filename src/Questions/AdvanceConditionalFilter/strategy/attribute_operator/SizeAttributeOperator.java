package Questions.AdvanceConditionalFilter.strategy.attribute_operator;

import Questions.AdvanceConditionalFilter.enums.Operator;
import Questions.AdvanceConditionalFilter.enums.SizeAttribute;

import java.util.List;

public class SizeAttributeOperator implements IAttributeOperatorStrategy{
    @Override
    public boolean isOperatorValid(Operator operator, Object value) {
        if (!(value instanceof SizeAttribute)) {
            // If it's IN operator, value should be a list of Sizes
            if (operator == Operator.IN && value instanceof List) {
                List<?> valueList = (List<?>) value;
                return valueList.stream().allMatch(v -> v instanceof SizeAttribute);
            }
            return false;
        }

        return operator == Operator.EQUALS ||
                operator == Operator.IN;
    }
}
