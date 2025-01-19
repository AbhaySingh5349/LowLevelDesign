package Questions.AdvanceConditionalFilter.strategy.attribute_operator;

import Questions.AdvanceConditionalFilter.enums.Operator;

public class AvailabilityAttributeOperator implements IAttributeOperatorStrategy{
    @Override
    public boolean isOperatorValid(Operator operator, Object value) {
        if (!(value instanceof Boolean)) return false;

        // Valid operators for AVAILABILITY are EQUALS (true/false)
        return operator == Operator.EQUALS;
    }
}
