package Questions.AdvanceConditionalFilter.strategy.attribute_operator;

import Questions.AdvanceConditionalFilter.enums.Operator;

public interface IAttributeOperatorStrategy {
    boolean isOperatorValid(Operator operator, Object value);
}
