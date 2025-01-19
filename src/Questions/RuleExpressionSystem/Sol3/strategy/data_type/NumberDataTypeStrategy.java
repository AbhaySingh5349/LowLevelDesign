package Questions.RuleExpressionSystem.Sol3.strategy.data_type;

import Questions.RuleExpressionSystem.Sol3.enums.Operator;

import java.util.EnumSet;

public class NumberDataTypeStrategy implements IDataTypeStrategy{
    private static final EnumSet<Operator> VALID_OPERATORS = EnumSet.of(
            Operator.EQUALS,
            Operator.NOT_EQUALS,
            Operator.GREATER_THAN,
            Operator.LESS_THAN,
            Operator.GREATER_THAN_OR_EQUALS,
            Operator.LESS_THAN_OR_EQUALS
    );

    @Override
    public boolean isOperatorValid(Operator operator) {
        return VALID_OPERATORS.contains(operator);
    }
}
