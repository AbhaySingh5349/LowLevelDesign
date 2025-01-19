package Questions.RuleExpressionSystem.Sol3.strategy.data_type;

import Questions.RuleExpressionSystem.Sol3.enums.Operator;

import java.util.EnumSet;

public class StringDataTypeStrategy implements IDataTypeStrategy{
    private static final EnumSet<Operator> VALID_OPERATORS = EnumSet.of(
            Operator.EQUALS,
            Operator.NOT_EQUALS,
            Operator.CONTAINS,
            Operator.STARTS_WITH,
            Operator.ENDS_WITH
    );

    @Override
    public boolean isOperatorValid(Operator operator) {
        return VALID_OPERATORS.contains(operator);
    }
}
